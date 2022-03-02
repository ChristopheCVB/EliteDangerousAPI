package com.christophecvb.elitedangerous;

import com.christophecvb.elitedangerous.events.Event;
import com.christophecvb.elitedangerous.events.StatusEvent;
import com.christophecvb.elitedangerous.events.other.FriendsEvent;
import com.google.gson.JsonParser;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EliteDangerousAPITest {

  private EliteDangerousAPI.Builder eliteDangerousAPIBuilder;
  private EliteDangerousAPI eliteDangerousAPI;

  private void build() {
    this.eliteDangerousAPI = this.eliteDangerousAPIBuilder.build();
  }

  @Before
  public void init() {
    this.eliteDangerousAPIBuilder = new EliteDangerousAPI.Builder();
  }

  @After
  public void uninit() {
    if (this.eliteDangerousAPI != null && this.eliteDangerousAPI.isActive()) {
      this.eliteDangerousAPI.stop();
    }
  }

  @Test
  public void testStatusEvent() {
    AtomicReference<StatusEvent> resultEvent = new AtomicReference<>(null);
    this.eliteDangerousAPIBuilder.addEventListener(StatusEvent.class,
        (StatusEvent.Listener) resultEvent::set);
    this.build();
    Event event = EliteDangerousAPI.GSON.fromJson(
        "{ \"timestamp\":\"2022-02-28T12:43:23Z\", \"event\":\"Status\", \"Flags\":16842765, \"Flags2\":0, \"Pips\":[4,8,0], \"FireGroup\":0, \"GuiFocus\":0, \"Fuel\":{ \"FuelMain\":64.000000, \"FuelReservoir\":1.160000 }, \"Cargo\":0.000000, \"LegalState\":\"Clean\", \"Balance\":1261218275 }",
        StatusEvent.class);
    this.eliteDangerousAPI.triggerEventIfNeededSafely(event);

    Assert.assertNotNull(resultEvent.get());
    Assert.assertEquals("type", "Status", resultEvent.get().type);
    Assert.assertTrue("isDocked", resultEvent.get().isDocked());
    Assert.assertFalse("isLanded", resultEvent.get().isLanded());
    Assert.assertTrue("isLandingGearDown", resultEvent.get().isLandingGearDown());
    Assert.assertTrue("areShieldsUp", resultEvent.get().areShieldsUp());
    Assert.assertFalse("isSupercruise", resultEvent.get().isSupercruise());
    Assert.assertFalse("isFlightAssistOff", resultEvent.get().isFlightAssistOff());
    Assert.assertFalse("areHardpointsDeployed", resultEvent.get().areHardpointsDeployed());
    Assert.assertFalse("isInWing", resultEvent.get().isInWing());
    Assert.assertFalse("areLightsOn", resultEvent.get().areLightsOn());
    Assert.assertFalse("isCargoScoopDeployed", resultEvent.get().isCargoScoopDeployed());
    Assert.assertFalse("isSilentRunning", resultEvent.get().isSilentRunning());
    Assert.assertFalse("isScoopingFuel", resultEvent.get().isScoopingFuel());
    Assert.assertFalse("isSRVHandbrake", resultEvent.get().isSRVHandbrake());
    Assert.assertFalse("isSRVUsingTurretView", resultEvent.get().isSRVUsingTurretView());
    Assert.assertFalse("isSRVTurretRetracted", resultEvent.get().isSRVTurretRetracted());
    Assert.assertFalse("isSRVDriveAssist", resultEvent.get().isSRVDriveAssist());
    Assert.assertTrue("isFSDMassLocked", resultEvent.get().isFSDMassLocked());
    Assert.assertFalse("isFSDCharging", resultEvent.get().isFSDCharging());
    Assert.assertFalse("isFSDCooldown", resultEvent.get().isFSDCooldown());
    Assert.assertFalse("isLowFuel", resultEvent.get().isLowFuel());
    Assert.assertFalse("isOverHeating", resultEvent.get().isOverHeating());
    Assert.assertFalse("hasLatLong", resultEvent.get().hasLatLong());
    Assert.assertFalse("isInDanger", resultEvent.get().isInDanger());
    Assert.assertFalse("isBeingInterdicted", resultEvent.get().isBeingInterdicted());
    Assert.assertTrue("isInMainShip", resultEvent.get().isInMainShip());
    Assert.assertFalse("isInFighter", resultEvent.get().isInFighter());
    Assert.assertFalse("isInSRV", resultEvent.get().isInSRV());
    Assert.assertFalse("isHUDInAnalysisMode", resultEvent.get().isHUDInAnalysisMode());
    Assert.assertFalse("isNightVision", resultEvent.get().isNightVision());
    Assert.assertFalse("isAltitudeFromAverageRadius", resultEvent.get().isAltitudeFromAverageRadius());
    Assert.assertFalse("isFSDJump", resultEvent.get().isFSDJump());
    Assert.assertFalse("isSRVHighBeam", resultEvent.get().isSRVHighBeam());
    Assert.assertFalse("isOnFoot", resultEvent.get().isOnFoot());
    Assert.assertFalse("isInTaxi", resultEvent.get().isInTaxi());
    Assert.assertFalse("isInMulticrew", resultEvent.get().isInMulticrew());
    Assert.assertFalse("isOnFootInStation", resultEvent.get().isOnFootInStation());
    Assert.assertFalse("isOnFootOnPlanet", resultEvent.get().isOnFootOnPlanet());
    Assert.assertFalse("isAimDownSight", resultEvent.get().isAimDownSight());
    Assert.assertFalse("isLowOxygen", resultEvent.get().isLowOxygen());
    Assert.assertFalse("isLowHealth", resultEvent.get().isLowHealth());
    Assert.assertFalse("isCold", resultEvent.get().isCold());
    Assert.assertFalse("isHot", resultEvent.get().isHot());
    Assert.assertFalse("isVeryCold", resultEvent.get().isVeryCold());
    Assert.assertFalse("isVeryHot", resultEvent.get().isVeryHot());
    Assert.assertFalse("isGlideMode", resultEvent.get().isGlideMode());
    Assert.assertFalse("isOnFootInHangar", resultEvent.get().isOnFootInHangar());
    Assert.assertFalse("isOnFootSocialSpace", resultEvent.get().isOnFootSocialSpace());
    Assert.assertFalse("isOnFootExterior", resultEvent.get().isOnFootExterior());
    Assert.assertFalse("isBreathableAtmosphere", resultEvent.get().isBreathableAtmosphere());
    Assert.assertEquals("fuel.fuelMain", new Double(64), resultEvent.get().fuel.fuelMain);
    Assert.assertEquals("fuel.fuelReservoir", new Double(1.16), resultEvent.get().fuel.fuelReservoir);
    Assert.assertEquals("cargo", new Double(0), resultEvent.get().cargo);
    Assert.assertEquals("legalState", "Clean", resultEvent.get().legalState);
    Assert.assertEquals("guiFocus", new Integer(0), resultEvent.get().guiFocus);
    Assert.assertEquals("fireGroup", new Integer(0), resultEvent.get().fireGroup);
    Assert.assertArrayEquals("pips", new Integer[]{4, 8, 0}, resultEvent.get().pips);
    Assert.assertNull("altitude", resultEvent.get().altitude);
    Assert.assertNull("latitude", resultEvent.get().latitude);
    Assert.assertNull("longitude", resultEvent.get().longitude);
    Assert.assertNull("heading", resultEvent.get().heading);
    Assert.assertNull("bodyName", resultEvent.get().bodyName);
    Assert.assertNull("planetRadius", resultEvent.get().planetRadius);
    Assert.assertNull("oxygen", resultEvent.get().oxygen);
    Assert.assertNull("health", resultEvent.get().health);
    Assert.assertNull("temperature", resultEvent.get().temperature);
    Assert.assertNull("selectedWeapon", resultEvent.get().selectedWeapon);
    Assert.assertNull("gravity", resultEvent.get().gravity);
  }

  @Test
  public void testTriggerEventsSince() throws ParseException {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
    Date triggerEventsSince = dateFormat.parse("2022-02-28T12:40:07Z");
    this.eliteDangerousAPIBuilder.setTriggerEventsSince(triggerEventsSince);

    AtomicReference<FriendsEvent> resultEvent = new AtomicReference<>(null);
    this.eliteDangerousAPIBuilder
        .addEventListener(FriendsEvent.class, (FriendsEvent.Listener) resultEvent::set);
    this.build();

    Assert.assertEquals(triggerEventsSince, this.eliteDangerousAPI.getTriggerEventsSince());

    Event pastEvent = this.eliteDangerousAPI.parseEvent(JsonParser.parseString(
            "{ \"timestamp\":\"2022-02-28T12:40:06Z\", \"event\":\"Friends\", \"Status\":\"Online\", \"Name\":\"Geraldine Shattner\" }")
        .getAsJsonObject());
    this.eliteDangerousAPI.triggerEventIfNeededSafely(pastEvent);

    Assert.assertNull(resultEvent.get());

    Event event = this.eliteDangerousAPI.parseEvent(JsonParser.parseString(
            "{ \"timestamp\":\"2022-02-28T12:40:08Z\", \"event\":\"Friends\", \"Status\":\"Online\", \"Name\":\"Geraldine Shattner\" }")
        .getAsJsonObject());
    this.eliteDangerousAPI.triggerEventIfNeededSafely(event);

    Assert.assertNotNull(resultEvent.get());
  }

  @Test
  public void testFriendsEvent() {
    AtomicReference<FriendsEvent> resultEvent = new AtomicReference<>(null);
    this.eliteDangerousAPIBuilder.addEventListener(FriendsEvent.class,
        (FriendsEvent.Listener) resultEvent::set);
    this.build();
    Event event = this.eliteDangerousAPI.parseEvent(JsonParser.parseString(
            "{ \"timestamp\":\"2022-02-28T12:40:06Z\", \"event\":\"Friends\", \"Status\":\"Online\", \"Name\":\"Geraldine Shattner\" }")
        .getAsJsonObject());
    this.eliteDangerousAPI.triggerEventIfNeededSafely(event);

    Assert.assertNotNull(resultEvent.get());
    Assert.assertEquals("Friends", resultEvent.get().type);
    Assert.assertEquals("Online", resultEvent.get().status);
    Assert.assertEquals("Geraldine Shattner", resultEvent.get().name);
  }
}
