package com.friend.farmers.respository;


import com.friend.farmers.models.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdrItemRepository extends JpaRepository<OrderItem,Long> {
}
