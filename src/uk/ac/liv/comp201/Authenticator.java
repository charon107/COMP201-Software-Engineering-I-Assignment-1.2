package uk.ac.liv.comp201;

import static uk.ac.liv.comp201.ResponseCode.*;

public class Authenticator {
    private Card card;
    private String passcodeFire;
    private String passcodeBurglary;

    public Authenticator(Card card) {
        this.card = card;
    }

    public ResponseCode checkFireCode(String passCodeFire) {
        ResponseCode returnValue = OK;
        // TO DO
        // 1. Add code to validate fire code
        // 2. Code to check fire code is correct for card
        // 3. Code to return appropriate response
        // 4. Add code to lock card, if wrong fire code is
        // entered wrong 3 times in sequence, lockout works
        // independently for the two codes
        if (card.getCardStatus() == 3) {
            returnValue = CARD_STATUS_BAD;
        } else if (card.getCardStatus() == 2) {
            returnValue = CARD_LOCKED;
        } else {
            int NotLetterOrDigit = 0;
            for (int i = 0; i <= passCodeFire.length(); i++) {
                if (!Character.isLetterOrDigit(passCodeFire.charAt(i))) {
                    NotLetterOrDigit++;
                }
            }
            if (passCodeFire.length() < 10 || passCodeFire.length() > 14 || NotLetterOrDigit != 0) {
                card.CountFireCodeAddOne();
                if (card.getCountFireCode() == 3) {
                    returnValue = CARD_LOCKED;
                    card.setCardStatus(2);
                } else {
                    returnValue = INVALID_FIRE_CODE;
                }

            } else if (passCodeFire.equals(card.getCardFireCode())) {
                card.ResetCountFireCode();
            } else {
                card.CountFireCodeAddOne();
                if (card.getCountFireCode() == 3) {
                    returnValue = CARD_LOCKED;
                    card.setCardStatus(2);
                } else {
                    returnValue = INVALID_FIRE_CODE;
                }
            }
        }

        return (returnValue);
    }

    public ResponseCode checkBurglaryCode(String passcodeBurglary) {
        ResponseCode returnValue = OK;
        // TO DO
        // 1. Add code to validate burglary code
        // 2. Code to check burglary code is correct for card
        // 3. Code to return appropriate response
        // 4. Add code to lock card, if wrong code is
        // entered wrong 3 times in sequence, lockout works
        // independently for the two codes
        if (card.getCardStatus() == 3) {
            returnValue = CARD_STATUS_BAD;
        } else if (card.getCardStatus() == 2) {
            returnValue = CARD_LOCKED;
        } else {
            int NotLetterOrDigit = 0;
            for (int i = 0; i <= passcodeBurglary.length(); i++) {
                if (!Character.isDigit(passcodeBurglary.charAt(i))) {
                    NotLetterOrDigit++;
                }
            }
            if (passcodeBurglary.length() < 8 || passcodeBurglary.length() > 9 || NotLetterOrDigit != 0) {
                card.CountBurlaryCodeAddone();
                if (card.getCountBurlaryCode() == 3) {
                    returnValue = CARD_LOCKED;
                    card.setCardStatus(2);
                } else {
                    returnValue = INVALID_FIRE_CODE;
                }

            } else if (passcodeBurglary.equals(card.getCardBurlaryCode())) {
                card.ResetCountBurlaryCode();
            } else {
                card.CountBurlaryCodeAddone();
                if (card.getCountBurlaryCode() == 3) {
                    returnValue = CARD_LOCKED;
                    card.setCardStatus(2);
                } else {
                    returnValue = INVALID_FIRE_CODE;
                }
            }
        }
        return (returnValue);
    }


}
