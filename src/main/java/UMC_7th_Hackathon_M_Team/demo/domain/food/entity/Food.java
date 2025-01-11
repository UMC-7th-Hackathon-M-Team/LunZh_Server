package UMC_7th_Hackathon_M_Team.demo.domain.food.entity;

import UMC_7th_Hackathon_M_Team.demo.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
    public class Food extends BaseEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
    
        @Column(nullable = false)
        private String name;
    }
