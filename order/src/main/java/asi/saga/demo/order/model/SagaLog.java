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
package asi.saga.demo.order.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.ZonedDateTime;

@Entity
@Table(name = "sagalog")
public class SagaLog {
    @Id
    String id;
    int state;

    @Column(name = "orderinfo")
    String orderInfo;

    @Column(name = "created_at")
    private ZonedDateTime createdAt;

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "SagaLog{" +
                "id='" + id + '\'' +
                ", state=" + state +
                ", orderInfo='" + orderInfo + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getState() {
        return state;
    }

    public SagaLog() {
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(String orderInfo) {
        this.orderInfo = orderInfo;
    }

    public SagaLog(String id, int state, String orderinfo) {
        this.id = id;
        this.state = state;
        this.orderInfo = orderinfo;
        this.createdAt = ZonedDateTime.now();
    }

}
