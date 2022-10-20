package com.restfuljenkinsexample.restfuljenkinsexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;

@SpringBootApplication
public class RestfulJenkinsExampleApplication {
	public static HashMap<Long, Player> PlayerHm;

	public static void main(String[] args) {

		PlayerHm = new HashMap<Long, Player>();

		Player player_1 = new Player(1, "Cristiano Ronaldo", "Real Madrid");
		PlayerHm.put(new Long(player_1.getId()), player_1);

		SpringApplication.run(RestfulJenkinsExampleApplication.class, args);

		Player player_2 = new Player(2, "Lionel Messi", "FC Barcelona");
		PlayerHm.put(new Long(player_2.getId()), player_2);

		Player player_3 = new Player(3, "Son", "Manchaster");
		PlayerHm.put(new Long(player_3.getId()), player_3);

		Player player_4 = new Player(2, "Honaldoo", "FC Seoul");
		PlayerHm.put(new Long(player_4.getId()), player_4);

		Player player_5 = new Player(2, "Hwang Hee Chan", "FC Jeonju");
		PlayerHm.put(new Long(player_5.getId()), player_5);
	}

}