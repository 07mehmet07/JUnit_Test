package test.java.paramstests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import main.java.SubscriptionManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubscriptionManagerTest {
    SubscriptionManager manager;

    @BeforeAll
    static void setUp() {
        System.out.println("==>TEST STARTED!<==");
    }

    @BeforeEach
    void startTestCase() {
        System.out.println("Test Case Started!");
        manager = new SubscriptionManager();
    }

    @AfterAll
    static void tearDown() {
        System.out.println("==>TEST FINISHED!<==");
    }

    @AfterEach
    void finishTestCase() {
        System.out.println("Test Case Finished!");
        manager = null;
        System.out.println("-----------------------");
    }

    @Test
    public void testFreeTierEmailNotificationEnabledAutoRenewal() {
        String result = manager.configureSubscription(SubscriptionManager.SubscriptionTier.FREE,
                SubscriptionManager.NotificationPreference.EMAIL,
                SubscriptionManager.AutoRenewal.ENABLED);

        assertEquals("Subscription Configured: Tier=FREE, Notification=EMAIL, " +
                "AutoRenewal=ENABLED", result);
    }

    @ParameterizedTest
    @CsvSource({"STANDARD, SMS, DISABLED",
            "PREMIUM, NONE, ENABLED",
            "FREE, SMS, DISABLED",
            "STANDARD, EMAIL, ENABLED",
            "PREMIUM, NONE, DISABLED"})
    void Test(SubscriptionManager.SubscriptionTier tier,
              SubscriptionManager.NotificationPreference notification,
              SubscriptionManager.AutoRenewal autoRenewal) {
        String result = "Subscription Configured: Tier=" + tier + ", Notification=" +
                notification + ", AutoRenewal=" + autoRenewal;

        assertEquals(result, manager.configureSubscription(tier, notification, autoRenewal));
    }
}
