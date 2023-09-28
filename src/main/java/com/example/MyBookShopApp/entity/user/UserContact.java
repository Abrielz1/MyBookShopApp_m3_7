package com.example.MyBookShopApp.entity.user;

import com.example.MyBookShopApp.entity.enums.ContactType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.proxy.HibernateProxy;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
    @Setter
    @ToString
@NoArgsConstructor
    @AllArgsConstructor
    @Builder(toBuilder = true)
    @Entity
    @Table(name = "user_contact")
    public class UserContact {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(columnDefinition = "INT NOT NULL")
        private Long userId;

        private ContactType type;

        @Column(columnDefinition = "SMALLINT NOT NULL")
        private short approved;

        @Column(columnDefinition = "VARCHAR(255) NOT NULL")
        private String code;

        @Column(columnDefinition = "INT")
        private int codeTrails;

        @Column(columnDefinition = "TIMESTAMP")
        private LocalDateTime codeTime;

        @Column(columnDefinition = "VARCHAR(255) NOT NULL")
        private String contact;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        UserContact that = (UserContact) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
