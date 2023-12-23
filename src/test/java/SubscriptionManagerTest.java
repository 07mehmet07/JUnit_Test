package test.java;

import main.java.SubscriptionManager;
import org.junit.jupiter.api.Test;

import static main.java.SubscriptionManager.NotificationPreference.EMAIL;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubscriptionManagerTest {
    SubscriptionManager manager = new SubscriptionManager();

    /*
    This test case is for Pairwise Test
     */


    @Test
    public void testFreeTierEmailNotificationsEnabledAutoRenewal() {
        String result = manager.configureSubscription(SubscriptionManager.SubscriptionTier.FREE,
                SubscriptionManager.NotificationPreference.EMAIL, SubscriptionManager.AutoRenewal.ENABLED);
        assertEquals("Subscription Configured: Tier=FREE, Notification=EMAIL, AutoRenewal=ENABLED", result);
    }

    @Test
    void testStandardTierSmsNotificationsDisabledAutoRenewal() {
        String result = manager.configureSubscription(SubscriptionManager.SubscriptionTier.STANDARD, SubscriptionManager.NotificationPreference.SMS, SubscriptionManager.AutoRenewal.DISABLED);
        assertEquals("Subscription Configured: Tier=STANDARD, Notification=SMS, AutoRenewal=DISABLED", result);

    }

    @Test
    void testPremiumTierNoneNotificationsEnabledAutoRenewal() {
        String result = manager.configureSubscription(SubscriptionManager.SubscriptionTier.PREMIUM, SubscriptionManager.NotificationPreference.NONE, SubscriptionManager.AutoRenewal.ENABLED);
        assertEquals("Subscription Configured: Tier=PREMIUM, Notification=NONE, AutoRenewal=ENABLED", result);

    }

    @Test
    public void testFreeTierEmailNotificationDisabledAutoRenewal() {
        String result = manager.configureSubscription(SubscriptionManager.SubscriptionTier.FREE, SubscriptionManager.NotificationPreference.SMS, SubscriptionManager.AutoRenewal.DISABLED);
        assertEquals("Subscription Configured: Tier=FREE, Notification=SMS, AutoRenewal=DISABLED", result);
    }

    @Test
    public void testStandardTierEmailNotificationEnabledAutoRenewal() {
        String result = manager.configureSubscription(SubscriptionManager.SubscriptionTier.STANDARD,
                SubscriptionManager.NotificationPreference.EMAIL,
                SubscriptionManager.AutoRenewal.ENABLED);
        assertEquals("Subscription Configured: Tier=STANDARD, Notification=EMAIL, " +
                "AutoRenewal=ENABLED", result);
    }

    @Test
    public void testPremiumTierSmsNotificationDisabledAutoRenewal() {
        String result = manager.configureSubscription(SubscriptionManager.SubscriptionTier.PREMIUM,
                SubscriptionManager.NotificationPreference.SMS,
                SubscriptionManager.AutoRenewal.DISABLED);
        assertEquals("Subscription Configured: Tier=PREMIUM, Notification=SMS, " +
                "AutoRenewal=DISABLED", result);
    }
}
