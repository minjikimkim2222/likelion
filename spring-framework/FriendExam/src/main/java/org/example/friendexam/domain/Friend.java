package org.example.friendexam.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode //  이것까지 만들어주다니,, 정말 미쳤군,,
@Table
public class Friend {
    @Id
    private Long id;
    private String name;
    private String email;
}
