package br.com.wa.http.domain.response;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DefaultResponse {

    protected String status = "SUCCESS";
    private List<String> messages = new ArrayList<String>();

    public DefaultResponse(String status, String message) {
        this.status = status;
        this.messages = Arrays.asList(message);
    }

    public DefaultResponse(String status, List<String> messages) {
        this.status = status;
        this.messages = messages;
    }

}
