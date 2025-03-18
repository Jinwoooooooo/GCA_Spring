package kr.co.ch07.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.co.ch07.dto.CustomerDTO;
import kr.co.ch07.dto.ProductAggDTO;
import kr.co.ch07.entity.shop.*;
import kr.co.ch07.repository.shop.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.spel.ast.Projection;

import java.util.List;

@SpringBootTest
class ShopRepositoryTest {


    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    QCustomer qCustomer = QCustomer.customer;
    QProduct qProduct = QProduct.product;
    QOrder qOrder = QOrder.order;

    @Test
    public void test1(){
        List<Customer> customerList = customerRepository.selectAllCustomer();
        System.out.println(customerList);
    }

    @Test
    public void test2(){
        Customer customer = customerRepository.selectCustomer("a101");
        System.out.println(customer);
    }

    @Test
    public void test3(){

        List<Product> products = jpaQueryFactory
                .selectFrom(qProduct)
                .fetch();

        System.out.println(products);
    }

    @Test
    public void test4(){
        List<Customer> customers = jpaQueryFactory
                .select(
                        Projections.fields(
                                Customer.class,
                                qCustomer.custId,
                                qCustomer.name,
                                qCustomer.age
                        )
                )
                .from(qCustomer)
                .fetch();

        System.out.println(customers);
    }

    @Test
    public void test5(){
        List<Customer> customers1 = jpaQueryFactory
                .selectFrom(qCustomer)
                .where(qCustomer.name.eq("김유신"))
                .fetch();

        System.out.println(customers1);

        List<Customer> customers2 = jpaQueryFactory
                .selectFrom(qCustomer)
                .where(qCustomer.name.ne("김유신"))
                .fetch();

        System.out.println(customers2);

    }

    @Test
    public void test6(){
        List<Customer> result1 = jpaQueryFactory.selectFrom(qCustomer).where(qCustomer.age.gt(30)).fetch();     // ~ where age > 30
        List<Customer> result2 = jpaQueryFactory.selectFrom(qCustomer).where(qCustomer.age.goe(30)).fetch();    // ~ where age >= 30
        List<Customer> result3 = jpaQueryFactory.selectFrom(qCustomer).where(qCustomer.age.lt(30)).fetch();     // ~ where age < 30
        List<Customer> result4 = jpaQueryFactory.selectFrom(qCustomer).where(qCustomer.age.loe(30)).fetch();

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
    }

    @Test
    public void test7(){
        // select * from customer where age in (21, 31, 41)
        List<Customer> customers = jpaQueryFactory.selectFrom(qCustomer)
                .where(qCustomer.age.in(21, 31, 41))
                .fetch();

        System.out.println(customers);
    }

    @Test
    public void test8(){
        // select ~ where name like '%신'
        List<Customer> customers = jpaQueryFactory
                .selectFrom(qCustomer)
                .where(qCustomer.name.like("%신"))
                .fetch();

        System.out.println(customers);
    }

    @Test
    public void test9(){
        // select ~ where productStock > 0 order by price desc;
        List<Product> products = jpaQueryFactory.selectFrom(qProduct)
                .where(qProduct.productStock.gt(0))
                .orderBy(qProduct.productPrice.desc())
                .fetch();

        System.out.println(products);
    }

    @Test
    public void test10(){
        // select ~ where stock > 0 order by price asc limit 0, 3
        List<Product> products = jpaQueryFactory.selectFrom(qProduct)
                .where(qProduct.productStock.gt(0))
                .orderBy(qProduct.productPrice.asc())
                .offset(0)
                .limit(3)
                .fetch();

        System.out.println(products);

    }

    @Test
    public void test11(){

        // kr.co.ch07.dto.ProductAggDTO 생성
        ProductAggDTO dto = jpaQueryFactory
                .select(
                        // ProductAggDTO 클래스 정의
                        Projections.fields(
                                ProductAggDTO.class,
                                qProduct.productPrice.sum().as("priceSum"),
                                qProduct.productPrice.avg().as("priceAvg"),
                                qProduct.productPrice.max().as("priceMax"),
                                qProduct.productPrice.min().as("priceMin")
                        )
                )
                .from(qProduct)
                .fetchOne();

        System.out.println(dto);

    }

    @Test
    public void test12(){

        // kr.co.ch07.dto.CustomerDTO 생성
        // select ~ where orderPrice >= 50000 group by `orderer` having custId >= 2;
        List<CustomerDTO> orders = jpaQueryFactory
                .select(
                        Projections.fields(
                                CustomerDTO.class,
                                qOrder.customer.custId,
                                qOrder.customer.name,
                                qOrder.customer.custId.count().as("orderCount")
                        )
                )
                .from(qOrder)
                .where(qOrder.orderPrice.goe(String.valueOf(40000)))
                .groupBy(qOrder.customer.custId)
                .having(qOrder.customer.custId.count().goe(1))
                .fetch();

        System.out.println(orders);
    }

    @Test
    public void test13() {
        List<Tuple> result = jpaQueryFactory
                .select(qOrder, qCustomer)
                .from(qOrder)
                .join(qCustomer)
                .on(qOrder.customer.eq(qCustomer))
                .fetch();

        System.out.println(result);
    }

    @Test
    public void test14() {
        String name = null;
        Integer age = 21;

        // 동적 쿼리 생성 builder
        BooleanBuilder builder = new BooleanBuilder();

        if(name != null){
            builder.and(qCustomer.name.eq(name));
        }

        if(age != null){
            builder.and(qCustomer.age.goe(age));
        }

        List<Customer> customers = jpaQueryFactory
                .selectFrom(qCustomer)
                .where(builder)
                .fetch();

        System.out.println(customers);

    }

    @Test
    public void test15() {
        String keyword = "유신";

        // 동적쿼리 생성을 위한 BooleanExpression
        BooleanExpression expression = qCustomer
                .custId.containsIgnoreCase(keyword)
                .or(qCustomer.name.containsIgnoreCase(keyword));

        List<Customer> customers = jpaQueryFactory
                .selectFrom(qCustomer)
                .where(expression)
                .fetch();

        System.out.println(customers);

    }


}