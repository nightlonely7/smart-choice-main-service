package au.com.nab.smartchoice.dto.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "product")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ProductEntity extends BaseEntity {

    @Column(name = "product_id", unique = true)
    private String productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "category_id")
    private String categoryId;
}
