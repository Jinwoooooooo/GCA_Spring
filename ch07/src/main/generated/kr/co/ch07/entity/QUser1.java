package kr.co.ch07.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUser1 is a Querydsl query type for User1
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser1 extends EntityPathBase<User1> {

    private static final long serialVersionUID = 1001016962L;

    public static final QUser1 user1 = new QUser1("user1");

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final StringPath hp = createString("hp");

    public final StringPath name = createString("name");

    public final StringPath uid = createString("uid");

    public QUser1(String variable) {
        super(User1.class, forVariable(variable));
    }

    public QUser1(Path<? extends User1> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser1(PathMetadata metadata) {
        super(User1.class, metadata);
    }

}

