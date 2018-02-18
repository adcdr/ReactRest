package model;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class ServerState {
    public static AtomicInteger currentGamedId = new AtomicInteger();
    public static ConcurrentMap<Integer, Game> games = new ConcurrentHashMap<>();
    public static ConcurrentMap<String, User> users = new ConcurrentHashMap<>();
}
