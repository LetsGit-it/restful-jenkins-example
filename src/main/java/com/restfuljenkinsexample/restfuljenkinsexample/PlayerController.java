package com.restfuljenkinsexample.restfuljenkinsexample;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value="/player")
public class PlayerController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public HashMap<Long, Player> getAllPlayers() {
        return RestfulJenkinsExampleApplication.PlayerHm;
    }

    /**
     * GET use id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Player getPlayers(@PathVariable("id") final long id) throws Exception {

        Player player;

        if (RestfulJenkinsExampleApplication.PlayerHm.containsKey(id)) {
            player = RestfulJenkinsExampleApplication.PlayerHm.get(id);
        } else {
            throw new Exception("Player " + id + "does not exists");
        }

        return player;
    }

    /**
     * POST
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public HashMap<Long, Player> addPlayer(@RequestBody final Player player) throws Exception {

        if (player == null) {
            throw new Exception("You did not send data");
        } else {
            if (RestfulJenkinsExampleApplication.PlayerHm.containsKey(player.getId())) {
                throw new Exception("Player " + player.getId() + "does exists");
            } else {
                Player new_player = new Player(player.getId(), player.getName(), player.getTeam());
                RestfulJenkinsExampleApplication.PlayerHm.put(new_player.getId(), new_player);
            }
        }

        return RestfulJenkinsExampleApplication.PlayerHm;
    }

    /**
     * PUT
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Player udpatePlayer(@PathVariable("id") final long id, @RequestBody final Player player) throws Exception {

        if (RestfulJenkinsExampleApplication.PlayerHm.containsKey(id)) {
            player.setTeam("Real Madrid");
            RestfulJenkinsExampleApplication.PlayerHm.put(id, player);
        } else {
            throw new Exception("Player " + player.getId() + " does not exists");
        }

        return player;
    }

    /**
     * DELETE
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public HashMap<Long, Player> deletePlayer(@PathVariable("id") final long id, @RequestBody final Player player) throws Exception {

        if (RestfulJenkinsExampleApplication.PlayerHm.containsKey(id)) {
            RestfulJenkinsExampleApplication.PlayerHm.remove(id);
        } else {
            throw new Exception("Player " + player.getId() + " does not exists");
        }

        return RestfulJenkinsExampleApplication.PlayerHm;
    }


}