/*
* L1 Caching exists inside a Session whereas
* L2 Caching is shared across SessionFactory
* L2 Caching can be done only when
*   i) L2 cache is enabled in hibernate.cfg.xml
*   ii) The entity is marked as cacheable
*   iii) The record is already in L2 cache which means
*       - Session1 loads the entity → SELECT occurs
        - Hibernate places it into L2 cache
        - Session1 closes
        - Session2 requests the same entity ID
*/

package org.example.concepts;
import org.example.mobile.Mobile;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class L2CacheImpl {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(org.example.mobile.Mobile.class)
                .configure()
                .buildSessionFactory();
        /*
        * since Mobile class is @Cacheable (which enables L2 caching),
        * only one SELECT statement is executed (done by session1 and can be seen in the terminal)
        * session2 wont execute a SELECT statement since it will use L2 cache to get data.
        * */
        Session session1 = sessionFactory.openSession();
        Mobile mobile1Details = session1.find(Mobile.class,1);
        session1.close();
        Session session2 = sessionFactory.openSession();
        Mobile mobile1DetailsFromSameCache = session2.find(Mobile.class,1);
        session2.close();
        sessionFactory.close();
    }
}
