package com.example.book.gateway;

import org.springframework.stereotype.Service;


import com.example.book.api.BookDTO;
import com.rest.book.GatewayCommon;

@Service
public class IsbnGateway extends GatewayCommon {

    public static final String ISBN_GATEWAY_ENDPOINT = "http://some_3rd_party_org/api/register";

    public String registerBook(BookDTO book) {
        return genericPost(ISBN_GATEWAY_ENDPOINT, book, String.class);
    }

}
