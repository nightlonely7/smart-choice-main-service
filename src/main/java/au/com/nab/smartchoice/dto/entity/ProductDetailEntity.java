package au.com.nab.smartchoice.dto.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "product_detail")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ProductDetailEntity extends BaseEntity {

    @Column(name = "product_id", unique = true)
    private String productId;

    @Column(name = "html")
    private String html;

    @Column(name = "attributes")
    private String attributes;
}
