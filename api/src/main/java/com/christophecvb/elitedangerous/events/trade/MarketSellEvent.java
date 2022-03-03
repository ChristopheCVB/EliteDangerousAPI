package com.christophecvb.elitedangerous.events.trade;

import com.christophecvb.elitedangerous.events.Event;

public class MarketSellEvent extends Event {

  public Long marketID;
  public String type;
  public String typeLocalised;
  public Integer count;
  public Integer sellPrice;
  public Integer totalSale;
  public Integer avgPricePaid;
  public Boolean illegalGoods;
  public Boolean stolenGoods;
  public Boolean blackMarket;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onMarketSellEventTriggered((MarketSellEvent) event);
    }

    void onMarketSellEventTriggered(MarketSellEvent marketSellEvent);
  }
}
