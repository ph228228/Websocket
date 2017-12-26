package com.example.beans;

import net.sf.json.JSONObject;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

//每个客户端连接成功的时候在后台都会创建一个相应的MyWebsocket类
@ServerEndpoint("/websocket/{roomCode}")
public class MyWebsocket {

    //private static CopyOnWriteArraySet<MyWebsocket> websocketPools=new CopyOnWriteArraySet<MyWebsocket>();

    //concurrent包的线程安全Map，用来存放每个客户端对应的MyWebSocket对象。其中key为房间号标识
    private static Map<String, List<MyWebsocket>> sessionPools = new ConcurrentHashMap();

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    //当前客户所在房间的房间号
    private String roomCode;

    /**
     * 连接建立成功调用的方法
     *
     * @param session  可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     * @param roomCode 房间号
     */
    @OnOpen
    public void onOpen(@PathParam("roomCode") String roomCode, Session session) {
        this.session = session;
        //将连接地址的参数roomcode的值放入变量roomCode中
        this.roomCode = roomCode;
        if (sessionPools.containsKey(this.roomCode)) {
            sessionPools.get(this.roomCode).add(this);
        } else {
            sessionPools.put(this.roomCode, new LinkedList<MyWebsocket>());
            sessionPools.get(this.roomCode).add(this);
        }

    }

    @OnClose
    public void onClose() {
        sessionPools.get(roomCode).remove(this);
        try {
            this.session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        // 把客户端的消息解析为JSON对象
        JSONObject jsonObject = JSONObject.fromObject(message);
        //遍历map集合，将消息发送至同一个房间下的session
        Iterator<Map.Entry<String, List<MyWebsocket>>> iterator = sessionPools.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, List<MyWebsocket>> entry = iterator.next();
            if (entry.getKey().equals(this.roomCode)) {
                //判断若是为同一个房间，则遍历房间内的session，并发送消息
                for (MyWebsocket item : entry.getValue()) {
                    jsonObject.put("isSelf", item.equals(session));
                    try {
                        // 添加本条消息是否为当前会话本身发的标志
                        item.send(jsonObject.toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
            }
        }
    }

    private void send(String message) throws IOException {
        this.session.getAsyncRemote().sendText(message);
//this.session.getBasicRemote().sendText(message);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }

}