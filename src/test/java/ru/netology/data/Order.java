package ru.netology.data;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Order {

    String id;
    String created;
    String credit_id;
    String payment_id;
}
