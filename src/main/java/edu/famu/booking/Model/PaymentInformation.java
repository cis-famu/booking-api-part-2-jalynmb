package edu.famu.booking.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentInformation {
        private String cardNumber;
        private String expirationDate;
        private String billingAddress;

    }

