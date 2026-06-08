package com.codedgarcia.expenses.manager.category.entity;

import com.codedgarcia.expenses.manager.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categories", uniqueConstraints = {
        @UniqueConstraint(
                columnNames = {"user_id", "category_name"}
        )
})

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column(name = "category_name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private Type type;
}
