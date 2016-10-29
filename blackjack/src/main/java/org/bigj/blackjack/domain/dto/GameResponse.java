package org.bigj.blackjack.domain.dto;

/**
 * Created by arthan on 17.09.2016. | Project game-platform
 */
public class GameResponse {
    private String response;
    private String status = "info";

    public GameResponse(String response) {
        this.response = response;
    }

    public GameResponse(String response, String status) {
        this.response = response;
        this.status = status;
    }

    public String getResponse() {
        return response;
    }

    public String getStatus() {
        return status;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
