package com.tekup.locationvoiture.DAO.Entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class CarSpecification {
    private String brand;
    private String name;
    private TransmissionType transmissionType;
    private boolean status;

    public CarSpecification(String brand, String name, TransmissionType transmissionType, boolean status) {
        this.brand = brand;
        this.name = name;
        this.transmissionType = transmissionType;
        this.status = status;
    }

    public Specification<Car> build() {
        return new Specification<Car>() {
            @Override
            public Predicate toPredicate(Root<Car> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();

                if (brand != null) {
                    predicates.add(criteriaBuilder.equal(root.get("brand"), brand));
                }

                if (name != null) {
                    predicates.add(criteriaBuilder.equal(root.get("name"), name));
                }

                if (transmissionType != null) {
                    predicates.add(criteriaBuilder.equal(root.get("transmissionType"), transmissionType));
                }

                if (status != false) {
                    predicates.add(criteriaBuilder.equal(root.get("status"), status));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            }
        };
    }
}