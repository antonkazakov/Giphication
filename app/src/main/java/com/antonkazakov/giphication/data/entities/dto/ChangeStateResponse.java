package com.antonkazakov.giphication.data.entities.dto;

/**
 * @author Anton Kazakov
 * @date 02.08.17.
 */

public class ChangeStateResponse {

    boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
