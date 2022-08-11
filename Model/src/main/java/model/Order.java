package model;

import java.util.Collection;

public class Order {

    private Collection<OrderLine> orderLines;

    private Seller seller;

    private boolean isSharedOrder;
}
