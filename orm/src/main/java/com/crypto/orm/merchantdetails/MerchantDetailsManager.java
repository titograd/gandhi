package com.crypto.orm.merchantdetails;


import com.crypto.domain.api.MerchantRegistrationServiceAPI;
import com.crypto.domain.core.Merchant;
import com.crypto.orm.entities.MerchantDetails;
import com.crypto.orm.utils.HibernateUtils;
import org.hibernate.Session;

/*
* This class is an adapter that can interact with the database.
* We use Merchant details as an abstraction layer and we map the values
* of the merchant object to the values of the merchandetails object.
* By doing this we avoid using the hibernate module in the domain layer(That would be
* a costly bad practice)
* */

public class MerchantDetailsManager implements MerchantRegistrationServiceAPI {

    @Override
    public void register(Merchant merchant) {
        //TODO: Refactor
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();
        MerchantDetails merchantDetails = new MerchantDetails();
        merchantDetails.setUserName(merchant.getUsername());
        merchantDetails.setPassword(merchant.getPassword());
        merchantDetails.setEmail(merchant.getEmail());
        session.save(merchantDetails);
        session.getTransaction().commit();
    }
}
