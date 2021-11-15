package com.yactayo.xprs.modelsDTO;

import com.yactayo.xprs.modelsDAO.ProductDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ListCard {
    private final List<ItemCard> items;

    public ListCard() {
        this.items = new ArrayList<>();
    }

    public void addItemCard(ItemCard itemCard) {
        if (items.contains(itemCard)) {
            Optional<ItemCard> optionalItemCard = items.stream()
                    .filter(i -> i.equals(itemCard))
                    .findAny();
            if (optionalItemCard.isPresent()) {
                ItemCard item = optionalItemCard.get();
                item.setQuantity(item.getQuantity() + 1);
            }
        } else {
            this.items.add(itemCard);
        }
    }

    public List<ItemCard> getItems() {
        return items;
    }
    public void getstockTotal() {
        for (int i = 0; i < items.size(); i++) {
            Product pr = new Product();
            int quantity = items.get(i).getQuantity();
            int idProduct = items.get(i).getProduct().getIdProduct();
            int stockT = items.get(i).getProduct().getStock();
            ProductDAO aO = new ProductDAO();
            pr = aO.byId(idProduct);
            int stock = stockT - quantity;
            int stock0 = stockT * 0;
            //Accion
            if (stock > 0) {
                aO.updateStock(idProduct, stock);
            } else {
                aO.updateStock(idProduct, stock0);
            }
        }
    }


    public double getTotal() {
        return items.stream().mapToDouble(ItemCard::getSubtotal).sum();
    }

    public void removeItem(int idProducto) {
        items.removeIf(item -> item.getProduct().getIdProduct() == idProducto);
    }

}
