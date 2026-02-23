package com.example.demo;

import io.lettuce.core.*;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import org.springframework.beans.factory.annotation.Value;

public class ConnectBasicTest {

    @Value("${REDIS_PASSWORD}")
    private String redis_password;

    public void connectBasic() {
        RedisURI uri = RedisURI.Builder
                .redis("redis-15623.crce196.sa-east-1-2.ec2.cloud.redislabs.com", 15623)
                .withAuthentication("default", redis_password)
                .build();
        RedisClient client = RedisClient.create(uri);
        StatefulRedisConnection<String, String> connection = client.connect();
        RedisCommands<String, String> commands = connection.sync();

        commands.set("foo", "bar");
        String result = commands.get("foo");
        System.out.println(result); // >>> bar

        connection.close();

        client.shutdown();
    }
}
