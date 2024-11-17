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

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class OrderMessage {
     private String cardid;
     private String issuer;

     @JsonProperty("itemList")
     private List<ItemList> itemList;

     @Override
     public String toString() {
          return "{" +
                  "cardid='" + cardid + '\'' +
                  ", issuer='" + issuer + '\'' +
                  ", itemList =" + itemList +
                  '}';
     }

     public String getCardid() {
          return cardid;
     }

     public void setCardid(String cardid) {
          this.cardid = cardid;
     }

     public String getIssuer() {
          return issuer;
     }

     public void setIssuer(String issuer) {
          this.issuer = issuer;
     }

     public OrderMessage() {
          this.setItemLists(new ArrayList<>());
     }

     public List<ItemList> getItemLists() {
          return itemList;
     }

     public void setItemLists(List<ItemList> itemList) {
          this.itemList = itemList;
     }
}
