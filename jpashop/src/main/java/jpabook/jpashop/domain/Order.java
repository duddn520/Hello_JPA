package jpabook.jpashop.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Orders")
public class Order {

    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @OneToMany (mappedBy = "order")
    private List<Orderitem> orderitems = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "DELIVERY_ID")
    private Delivery delivery;

    //양방향 매핑 편의 메서드
    public void addOrderItem(Orderitem orderitem){
        orderitems.add(orderitem);
        orderitem.setOrder(this);
    }
    public List<Orderitem> getOrderitems() {
        return orderitems;
    }

    public void setOrderitems(List<Orderitem> orderitems) {
        this.orderitems = orderitems;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

}
