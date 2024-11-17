/*
MIT License

Copyright (c) 2023, Nuno Datia, ISEL

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package asi.saga.demo.order.controller;

import asi.saga.demo.order.model.OrderMessage;
import asi.saga.demo.common.model.Result;
import asi.saga.demo.order.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This a simplified version of what an order service can be.
 * It does not care about autenticated users, something that is key in a real solution.
 * It must implement the SAGA pattern, in its orchestrated variation.
 * */
@RestController
@RestControllerAdvice
public class OrderServiceController {
    private Logger __logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private OrderService _service;

    @Operation(summary = "Handle a payment request")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful payment operation",
                    content = @Content(schema = @Schema(implementation = asi.saga.demo.common.model.Result.class))),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })


    @PostMapping("/order-service/create")
    public ResponseEntity<String> createRequest(@RequestBody OrderMessage order) throws Exception {
        // process the object
        __logger.info("POST:order {}", order);

        _service.doSaga(order);


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Result res = new Result("Success", LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        return new ResponseEntity<>(new ObjectMapper().writeValueAsString(res), headers, HttpStatus.OK);
    }

    @GetMapping("/order-service/{sagaId}")
    public ResponseEntity<String> createRequest(@PathVariable String sagaId) throws Exception {
        // process the object
        _service.getSaga(sagaId);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Result res = new Result("Success", LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        return new ResponseEntity<>(new ObjectMapper().writeValueAsString(res), headers, HttpStatus.OK);
    }

}

