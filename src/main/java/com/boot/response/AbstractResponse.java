package com.boot.response;

import java.util.List;

public abstract class AbstractResponse<E> {
    private StatusResponse statusResponse;
    private List<E> entries;

    public StatusResponse getStatusResponse() {
        return statusResponse;
    }

    public void setStatusResponse(StatusResponse statusResponse) {
        this.statusResponse = statusResponse;
    }

    public List<E> getEntries() {
        return entries;
    }

    public void setEntries(List<E> entries) {
        this.entries = entries;
    }
}
