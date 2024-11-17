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
package asi.saga.demo.order.service;

import asi.saga.demo.order.model.OrderMessage;
import asi.saga.demo.order.model.SagaLog;
import asi.saga.demo.order.repository.SagaLogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * This a simplified version of what an order service can be.
 * It does not care about autenticated users, something that is key in a real solution.
 * It must implement the SAGA pattern, in its orchestrated variation.
 * */
@Service
public class OrderService
{
    private Logger __logger = LoggerFactory.getLogger(getClass());

    public enum State {
        ERROR(0),
        STATE1(1);
        private int value;

        State(int val) {
            this.value = val;
        }

        public int getValue() {
            return value;
        }
    }; //TODO
    @Autowired
    private SagaLogRepository _repo;


    /**
     * TODO: This is where the Saga
     * */

    public void doSaga(OrderMessage order) {

        //TODO
        SagaLog s = init(order);
        nextState(s);
       }
    public void getSaga(String sagaIdr) {
    }

    @Transactional
    private SagaLog init(OrderMessage order)
    {
        //TODO
        UUID uuid = UUID.randomUUID();
        __logger.info(order.toString());

        //TODO
        SagaLog s = new SagaLog(uuid.toString(),State.ERROR.getValue(),order.toString());
        _repo.saveAndFlush(s);
        return s;
    }
    @Transactional
    private SagaLog nextState(SagaLog s)
    {
        //TODO
        s.setState(State.STATE1.getValue());
        _repo.saveAndFlush(s);
        return s;
    }
}
