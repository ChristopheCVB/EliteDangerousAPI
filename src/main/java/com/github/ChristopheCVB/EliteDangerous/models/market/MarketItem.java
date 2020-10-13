package com.github.ChristopheCVB.EliteDangerous.models.market;

public class MarketItem {

    private Integer id, buyPricce, sellPrice, meanPrice, stockBracket, demandBracket, stock, demand;
    private String name, category;
    private Boolean consumer, producer, rare;

    public MarketItem(Integer id, Integer buyPricce, Integer sellPrice, Integer meanPrice, Integer stockBracket,
                      Integer demandBracket, Integer stock, Integer demand, String name, String category, Boolean consumer,
                      Boolean producer, Boolean rare) {
        this.id = id;
        this.buyPricce = buyPricce;
        this.sellPrice = sellPrice;
        this.meanPrice = meanPrice;
        this.stockBracket = stockBracket;
        this.demandBracket = demandBracket;
        this.stock = stock;
        this.demand = demand;
        this.name = name;
        this.category = category;
		this.consumer = consumer;
		this.producer = producer;
		this.rare = rare;
	}

	public Integer getId() {
		return id;
	}

	public Integer getBuyPricce() {
		return buyPricce;
	}

	public Integer getSellPrice() {
		return sellPrice;
	}

	public Integer getMeanPrice() {
		return meanPrice;
	}

	public Integer getStockBracket() {
		return stockBracket;
	}

	public Integer getDemandBracket() {
		return demandBracket;
	}

	public Integer getStock() {
		return stock;
	}

	public Integer getDemand() {
		return demand;
	}

	public String getName() {
		return name;
	}

	public String getCategory() {
		return category;
	}

	public Boolean getConsumer() {
		return consumer;
	}

	public Boolean getProducer() {
		return producer;
	}

	public Boolean getRare() {
		return rare;
	}

}
