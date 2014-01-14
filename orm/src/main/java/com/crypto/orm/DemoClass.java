package com.crypto.orm;

import com.crypto.orm.entities.MerchantDetails;
import com.crypto.orm.utils.HibernateUtils;
import org.hibernate.Session;

public class DemoClass {
    public static void main( String[] args )
    {
        System.out.println("Maven + Hibernate + MySQL");
        Session session = HibernateUtils.getSessionFactory().openSession();

        session.beginTransaction();
        MerchantDetails merchantDetails = new MerchantDetails();

        merchantDetails.setUserName("djordje");
        merchantDetails.setUserName("1234");
        merchantDetails.setEmail("myemail@mail.com");

        session.save(merchantDetails);
        session.getTransaction().commit();
    }
}
