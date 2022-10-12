package com.christophecvb.elitedangerous;

import com.christophecvb.elitedangerous.events.Event;
import com.christophecvb.elitedangerous.events.StatusEvent;
import com.christophecvb.elitedangerous.events.combat.ShipTargetedEvent;
import com.christophecvb.elitedangerous.events.combat.ShipTargetedStage3Event;
import com.christophecvb.elitedangerous.events.exploration.ScanPlanetOrMoonEvent;
import com.christophecvb.elitedangerous.events.other.FriendsEvent;
import com.christophecvb.elitedangerous.events.other.MusicEvent;
import com.christophecvb.elitedangerous.events.startup.*;
import com.christophecvb.elitedangerous.events.travel.TouchdownEvent;
import com.christophecvb.elitedangerous.utils.GameFiles;
import com.google.gson.JsonParser;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicReference;

public class EliteDangerousAPITest {

  private EliteDangerousAPI.Builder eliteDangerousAPIBuilder;
  private EliteDangerousAPI eliteDangerousAPI;

  private void build() {
    this.eliteDangerousAPI = this.eliteDangerousAPIBuilder.build();
  }

  @Before
  public void init() {
    this.eliteDangerousAPIBuilder = new EliteDangerousAPI.Builder()
        .setGameFilesDirectory(new File("./src/test/resources/"));
  }

  @After
  public void uninit() {
    if (this.eliteDangerousAPI != null && this.eliteDangerousAPI.isActive()) {
      this.eliteDangerousAPI.stop();
    }
    // Reset GameFiles instance to default
    GameFiles.getInstance(null);
  }

  @Test
  public void testDefaultGameFilesDirectory() throws InterruptedException {
    this.eliteDangerousAPIBuilder.setGameFilesDirectory(null);
    this.build();

    this.eliteDangerousAPI.start();
    Assert.assertTrue(this.eliteDangerousAPI.isActive());

    Thread.sleep(100);

    this.eliteDangerousAPI.stop();
    Assert.assertFalse(this.eliteDangerousAPI.isActive());
  }

  @Test
  public void testWrongGameFilesDirectory() throws InterruptedException {
    this.eliteDangerousAPIBuilder.setGameFilesDirectory(new File("./"));
    this.build();

    this.eliteDangerousAPI.start();
    Assert.assertTrue(this.eliteDangerousAPI.isActive());

    Thread.sleep(100);

    this.eliteDangerousAPI.stop();
    Assert.assertFalse(this.eliteDangerousAPI.isActive());
  }

  @Test
  public void testNotExistingGameFilesDirectory() throws InterruptedException {
    this.eliteDangerousAPIBuilder.setGameFilesDirectory(new File("./gibberish"));
    this.build();

    this.eliteDangerousAPI.start();
    Assert.assertTrue(this.eliteDangerousAPI.isActive());

    Thread.sleep(100);

    this.eliteDangerousAPI.stop();
    Assert.assertFalse(this.eliteDangerousAPI.isActive());
  }

  @Test
  public void testStartStop() throws InterruptedException {
    this.build();

    this.eliteDangerousAPI.start();
    Assert.assertTrue(this.eliteDangerousAPI.isActive());

    Thread.sleep(100);

    this.eliteDangerousAPI.stop();
    Assert.assertFalse(this.eliteDangerousAPI.isActive());
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
    Assert.assertFalse("isAltitudeFromAverageRadius",
        resultEvent.get().isAltitudeFromAverageRadius());
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
    Assert.assertEquals("fuel.fuelReservoir", new Double(1.16),
        resultEvent.get().fuel.fuelReservoir);
    Assert.assertEquals("cargo", new Double(0), resultEvent.get().cargo);
    Assert.assertEquals("legalState", "Clean", resultEvent.get().legalState);
    Assert.assertEquals("guiFocus", new Integer(0), resultEvent.get().guiFocus);
    Assert.assertEquals("getGUIFocusName", "NoFocus",
        StatusEvent.getGUIFocusName(resultEvent.get().guiFocus));
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
    FriendsEvent event = getEvent(FriendsEvent.class, "{ \"timestamp\":\"2022-02-28T12:40:06Z\", \"event\":\"Friends\", \"Status\":\"Online\", \"Name\":\"Geraldine Shattner\" }");

    Assert.assertNotNull(event);
    Assert.assertEquals("type", "Friends", event.type);
    Assert.assertEquals("status", "Online", event.status);
    Assert.assertEquals("name", "Geraldine Shattner", event.name);
  }

  @Test
  public void testCommanderEvent() {
    CommanderEvent event = getEvent(CommanderEvent.class, "{ \"timestamp\":\"2022-02-28T12:40:34Z\", \"event\":\"Commander\", \"FID\":\"F4032179\", \"Name\":\"Melbar Kaasom\" }");

    Assert.assertNotNull(event);
    Assert.assertEquals("type", "Commander", event.type);
    Assert.assertEquals("fid", "F4032179", event.fid);
    Assert.assertEquals("name", "Melbar Kaasom", event.name);
  }

  @Test
  public void testMaterialsEvent() {
    MaterialsEvent event = getEvent(MaterialsEvent.class, "{ \"timestamp\":\"2022-02-28T12:40:34Z\", \"event\":\"Materials\", \"Raw\":[ { \"Name\":\"arsenic\", \"Name_Localised\":\"Arsen\", \"Count\":57 }, { \"Name\":\"manganese\", \"Name_Localised\":\"Mangan\", \"Count\":250 }, { \"Name\":\"sulphur\", \"Name_Localised\":\"Schwefel\", \"Count\":295 }, { \"Name\":\"germanium\", \"Count\":228 }, { \"Name\":\"ruthenium\", \"Count\":150 }, { \"Name\":\"mercury\", \"Name_Localised\":\"Quecksilber\", \"Count\":124 }, { \"Name\":\"iron\", \"Name_Localised\":\"Eisen\", \"Count\":297 }, { \"Name\":\"cadmium\", \"Name_Localised\":\"Kadmium\", \"Count\":160 }, { \"Name\":\"nickel\", \"Count\":297 }, { \"Name\":\"carbon\", \"Name_Localised\":\"Kohlenstoff\", \"Count\":296 }, { \"Name\":\"antimony\", \"Name_Localised\":\"Antimon\", \"Count\":92 }, { \"Name\":\"molybdenum\", \"Name_Localised\":\"Molibdän\", \"Count\":200 }, { \"Name\":\"tin\", \"Name_Localised\":\"Zinn\", \"Count\":200 }, { \"Name\":\"zirconium\", \"Count\":84 }, { \"Name\":\"chromium\", \"Name_Localised\":\"Chrom\", \"Count\":250 }, { \"Name\":\"vanadium\", \"Count\":250 }, { \"Name\":\"phosphorus\", \"Name_Localised\":\"Phosphor\", \"Count\":296 }, { \"Name\":\"selenium\", \"Name_Localised\":\"Selen\", \"Count\":133 }, { \"Name\":\"tungsten\", \"Name_Localised\":\"Wolfram\", \"Count\":138 }, { \"Name\":\"polonium\", \"Count\":58 }, { \"Name\":\"niobium\", \"Name_Localised\":\"Niob\", \"Count\":171 }, { \"Name\":\"yttrium\", \"Count\":127 }, { \"Name\":\"zinc\", \"Name_Localised\":\"Zink\", \"Count\":250 }, { \"Name\":\"tellurium\", \"Name_Localised\":\"Tellur\", \"Count\":34 }, { \"Name\":\"technetium\", \"Count\":48 }, { \"Name\":\"lead\", \"Name_Localised\":\"Blei\", \"Count\":297 }, { \"Name\":\"rhenium\", \"Count\":123 }, { \"Name\":\"boron\", \"Name_Localised\":\"Bor\", \"Count\":117 } ], \"Manufactured\":[ { \"Name\":\"mechanicalequipment\", \"Name_Localised\":\"Mechanisches Equipment\", \"Count\":61 }, { \"Name\":\"conductivecomponents\", \"Name_Localised\":\"Leitfähige Komponenten\", \"Count\":12 }, { \"Name\":\"shieldemitters\", \"Name_Localised\":\"Schildemitter\", \"Count\":55 }, { \"Name\":\"salvagedalloys\", \"Name_Localised\":\"Geborgene Legierungen\", \"Count\":102 }, { \"Name\":\"crystalshards\", \"Name_Localised\":\"Kristallscherben\", \"Count\":180 }, { \"Name\":\"chemicalstorageunits\", \"Name_Localised\":\"Lagerungseinheiten für Chemiestoffe\", \"Count\":3 }, { \"Name\":\"gridresistors\", \"Name_Localised\":\"Gitterwiderstände\", \"Count\":221 }, { \"Name\":\"mechanicalscrap\", \"Name_Localised\":\"Mechanischer Schrott\", \"Count\":158 }, { \"Name\":\"heatconductionwiring\", \"Name_Localised\":\"Wärmeleitungsverdrahtung\", \"Count\":29 }, { \"Name\":\"wornshieldemitters\", \"Name_Localised\":\"Gebrauchte Schildemitter\", \"Count\":174 }, { \"Name\":\"chemicalprocessors\", \"Name_Localised\":\"Chemische Prozessoren\", \"Count\":58 }, { \"Name\":\"electrochemicalarrays\", \"Name_Localised\":\"Elektrochemische Detektoren\", \"Count\":3 }, { \"Name\":\"conductiveceramics\", \"Name_Localised\":\"Elektrokeramiken\", \"Count\":1 }, { \"Name\":\"conductivepolymers\", \"Name_Localised\":\"Leitfähige Polymere\", \"Count\":134 }, { \"Name\":\"compoundshielding\", \"Name_Localised\":\"Verbundschilde\", \"Count\":115 }, { \"Name\":\"mechanicalcomponents\", \"Name_Localised\":\"Mechanische Komponenten\", \"Count\":2 }, { \"Name\":\"shieldingsensors\", \"Name_Localised\":\"Schildsensoren\", \"Count\":56 }, { \"Name\":\"heatdispersionplate\", \"Name_Localised\":\"Wärmeverteilungsplatte\", \"Count\":80 }, { \"Name\":\"phasealloys\", \"Name_Localised\":\"Phasenlegierungen\", \"Count\":92 }, { \"Name\":\"chemicaldistillery\", \"Name_Localised\":\"Chemiedestillerie\", \"Count\":20 }, { \"Name\":\"highdensitycomposites\", \"Name_Localised\":\"Komposite hoher Dichte\", \"Count\":100 }, { \"Name\":\"heatvanes\", \"Name_Localised\":\"Wärmeleitbleche\", \"Count\":33 }, { \"Name\":\"uncutfocuscrystals\", \"Name_Localised\":\"Fehlerhafte Fokuskristalle\", \"Count\":54 }, { \"Name\":\"chemicalmanipulators\", \"Name_Localised\":\"Chemische Manipulatoren\", \"Count\":9 }, { \"Name\":\"refinedfocuscrystals\", \"Name_Localised\":\"Raffinierte Laserkristalle\", \"Count\":150 }, { \"Name\":\"galvanisingalloys\", \"Name_Localised\":\"Galvanisierende Legierungen\", \"Count\":28 }, { \"Name\":\"heatexchangers\", \"Name_Localised\":\"Wärmeaustauscher\", \"Count\":11 }, { \"Name\":\"hybridcapacitors\", \"Name_Localised\":\"Hybridkondensatoren\", \"Count\":2 }, { \"Name\":\"focuscrystals\", \"Name_Localised\":\"Laserkristalle\", \"Count\":200 }, { \"Name\":\"basicconductors\", \"Name_Localised\":\"Einfache Leiter\", \"Count\":89 }, { \"Name\":\"exquisitefocuscrystals\", \"Name_Localised\":\"Erlesene Laserkristalle\", \"Count\":100 }, { \"Name\":\"biotechconductors\", \"Name_Localised\":\"Biotech-Leiter\", \"Count\":90 }, { \"Name\":\"thermicalloys\", \"Name_Localised\":\"Thermische Legierungen\", \"Count\":27 }, { \"Name\":\"filamentcomposites\", \"Name_Localised\":\"Filament-Komposite\", \"Count\":62 }, { \"Name\":\"guardian_powercell\", \"Name_Localised\":\"Guardian-Energiezelle\", \"Count\":66 }, { \"Name\":\"guardian_powerconduit\", \"Name_Localised\":\"Guardian-Energieleiter\", \"Count\":87 }, { \"Name\":\"heatresistantceramics\", \"Name_Localised\":\"Hitzefeste Keramik\", \"Count\":34 }, { \"Name\":\"temperedalloys\", \"Name_Localised\":\"Vergütete Legierungen\", \"Count\":3 }, { \"Name\":\"protoheatradiators\", \"Name_Localised\":\"Proto-Wärmestrahler\", \"Count\":46 }, { \"Name\":\"protolightalloys\", \"Name_Localised\":\"Leichte Legierungen (Proto)\", \"Count\":60 }, { \"Name\":\"protoradiolicalloys\", \"Name_Localised\":\"Radiologische Legierungen (Proto)\", \"Count\":41 }, { \"Name\":\"fedproprietarycomposites\", \"Name_Localised\":\"Kompositwerkstoffe\", \"Count\":106 }, { \"Name\":\"militarysupercapacitors\", \"Name_Localised\":\"Militärische Superkondensatoren\", \"Count\":2 }, { \"Name\":\"fedcorecomposites\", \"Name_Localised\":\"Core Dynamics Kompositwerkstoffe\", \"Count\":37 }, { \"Name\":\"militarygradealloys\", \"Name_Localised\":\"Militärqualitätslegierungen\", \"Count\":26 }, { \"Name\":\"precipitatedalloys\", \"Name_Localised\":\"Gehärtete Legierungen\", \"Count\":119 }, { \"Name\":\"compactcomposites\", \"Name_Localised\":\"Kompaktkomposite\", \"Count\":49 }, { \"Name\":\"guardian_sentinel_weaponparts\", \"Name_Localised\":\"Guardian-Wache-Waffenteile\", \"Count\":18 }, { \"Name\":\"guardian_sentinel_wreckagecomponents\", \"Name_Localised\":\"Guardian-Wrackteilkomponenten\", \"Count\":33 }, { \"Name\":\"unknownenergysource\", \"Name_Localised\":\"Sensorenfragment\", \"Count\":16 }, { \"Name\":\"improvisedcomponents\", \"Name_Localised\":\"Behelfskomponenten\", \"Count\":3 }, { \"Name\":\"imperialshielding\", \"Name_Localised\":\"Imperiale Schilde\", \"Count\":8 } ], \"Encoded\":[ { \"Name\":\"legacyfirmware\", \"Name_Localised\":\"Spezial-Legacy-Firmware\", \"Count\":124 }, { \"Name\":\"shieldpatternanalysis\", \"Name_Localised\":\"Abweichende Schildeinsatz-Analysen\", \"Count\":95 }, { \"Name\":\"emissiondata\", \"Name_Localised\":\"Unerwartete Emissionsdaten\", \"Count\":56 }, { \"Name\":\"disruptedwakeechoes\", \"Name_Localised\":\"Atypische FSA-Stör-Aufzeichnungen\", \"Count\":105 }, { \"Name\":\"fsdtelemetry\", \"Name_Localised\":\"Anormale FSA-Telemetrie\", \"Count\":119 }, { \"Name\":\"consumerfirmware\", \"Name_Localised\":\"Modifizierte Consumer-Firmware\", \"Count\":25 }, { \"Name\":\"decodedemissiondata\", \"Name_Localised\":\"Entschlüsselte Emissionsdaten\", \"Count\":95 }, { \"Name\":\"compactemissionsdata\", \"Name_Localised\":\"Anormale kompakte Emissionsdaten\", \"Count\":11 }, { \"Name\":\"shieldcyclerecordings\", \"Name_Localised\":\"Gestörte Schildzyklus-Aufzeichnungen\", \"Count\":58 }, { \"Name\":\"shielddensityreports\", \"Name_Localised\":\"Untypische Schildscans\", \"Count\":98 }, { \"Name\":\"scandatabanks\", \"Name_Localised\":\"Scan-Datenbanken unter Verschluss\", \"Count\":89 }, { \"Name\":\"scanarchives\", \"Name_Localised\":\"Unidentifizierte Scan-Archive\", \"Count\":91 }, { \"Name\":\"encryptedfiles\", \"Name_Localised\":\"Ungewöhnliche verschlüsselte Files\", \"Count\":15 }, { \"Name\":\"hyperspacetrajectories\", \"Name_Localised\":\"Exzentrische Hyperraum-Routen\", \"Count\":21 }, { \"Name\":\"wakesolutions\", \"Name_Localised\":\"Seltsame FSA-Zielorte\", \"Count\":37 }, { \"Name\":\"dataminedwake\", \"Name_Localised\":\"FSA-Daten-Cache-Ausnahmen\", \"Count\":18 }, { \"Name\":\"encryptioncodes\", \"Name_Localised\":\"Getaggte Verschlüsselungscodes\", \"Count\":78 }, { \"Name\":\"industrialfirmware\", \"Name_Localised\":\"Gecrackte Industrie-Firmware\", \"Count\":11 }, { \"Name\":\"bulkscandata\", \"Name_Localised\":\"Anormale Massen-Scan-Daten\", \"Count\":174 }, { \"Name\":\"archivedemissiondata\", \"Name_Localised\":\"Irreguläre Emissionsdaten\", \"Count\":41 }, { \"Name\":\"shieldsoakanalysis\", \"Name_Localised\":\"Inkonsistente Schildleistungsanalysen\", \"Count\":83 }, { \"Name\":\"unknownshipsignature\", \"Name_Localised\":\"Thargoiden-Schiffssignatur\", \"Count\":3 }, { \"Name\":\"encryptionarchives\", \"Name_Localised\":\"Atypische Verschlüsselungsarchive\", \"Count\":138 }, { \"Name\":\"adaptiveencryptors\", \"Name_Localised\":\"Adaptive Verschlüsselungserfassung\", \"Count\":84 }, { \"Name\":\"embeddedfirmware\", \"Name_Localised\":\"Modifizierte integrierte Firmware\", \"Count\":72 }, { \"Name\":\"securityfirmware\", \"Name_Localised\":\"Sicherheits-Firmware-Patch\", \"Count\":139 }, { \"Name\":\"scrambledemissiondata\", \"Name_Localised\":\"Außergewöhnliche verschlüsselte Emissionsdaten\", \"Count\":187 }, { \"Name\":\"encodedscandata\", \"Name_Localised\":\"Divergente Scandaten\", \"Count\":123 }, { \"Name\":\"shieldfrequencydata\", \"Name_Localised\":\"Verdächtige Schildfrequenz-Daten\", \"Count\":6 }, { \"Name\":\"ancientculturaldata\", \"Name_Localised\":\"Beta-Muster-Obeliskendaten\", \"Count\":6 }, { \"Name\":\"classifiedscandata\", \"Name_Localised\":\"Geheimes Scan-Fragment\", \"Count\":13 }, { \"Name\":\"symmetrickeys\", \"Name_Localised\":\"Offene symmetrische Schlüssel\", \"Count\":5 } ] }");

    Assert.assertNotNull(event);
    Assert.assertEquals("type", "Materials", event.type);
    Assert.assertEquals("raw.size", 28, event.raw.size());
    Assert.assertEquals("raw[0].name", "arsenic", event.raw.get(0).name);
    Assert.assertEquals("raw[0].count", new Integer(57), event.raw.get(0).count);
    Assert.assertEquals("encoded.size", 32, event.encoded.size());
    Assert.assertEquals("encoded[0].name", "legacyfirmware", event.encoded.get(0).name);
    Assert.assertEquals("encoded[0].count", new Integer(124),
        event.encoded.get(0).count);
    Assert.assertEquals("manufactured.size", 52, event.manufactured.size());
    Assert.assertEquals("manufactured[0].name", "mechanicalequipment",
        event.manufactured.get(0).name);
    Assert.assertEquals("manufactured[0].count", new Integer(61),
        event.manufactured.get(0).count);
  }

  @Test
  public void testRankEvent() {
    RankEvent event = getEvent(RankEvent.class, "{ \"timestamp\":\"2022-02-28T12:40:34Z\", \"event\":\"Rank\", \"Combat\":5, \"Trade\":9, \"Explore\":8, \"Soldier\":2, \"Exobiologist\":4, \"Empire\":14, \"Federation\":14, \"CQC\":0 }");

    Assert.assertNotNull(event);
    Assert.assertEquals("type", "Rank", event.type);
    Assert.assertEquals("combat", new Integer(5), event.combat);
    Assert.assertEquals("trade", new Integer(9), event.trade);
    Assert.assertEquals("combat", new Integer(8), event.explore);
    Assert.assertEquals("soldier", new Integer(2), event.soldier);
    Assert.assertEquals("exobiologist", new Integer(4), event.exobiologist);
    Assert.assertEquals("empire", new Integer(14), event.empire);
    Assert.assertEquals("federation", new Integer(14), event.federation);
    Assert.assertEquals("cqc", new Integer(0), event.cqc);
  }

  @Test
  public void testProgressEvent() {
    ProgressEvent event = getEvent(ProgressEvent.class, "{ \"timestamp\":\"2022-02-28T12:40:34Z\", \"event\":\"Progress\", \"Combat\":11, \"Trade\":76, \"Explore\":17, \"Soldier\":7, \"Exobiologist\":58, \"Empire\":100, \"Federation\":100, \"CQC\":0 }");

    Assert.assertNotNull(event);
    Assert.assertEquals("type", "Progress", event.type);
    Assert.assertEquals("combat", new Integer(11), event.combat);
    Assert.assertEquals("trade", new Integer(76), event.trade);
    Assert.assertEquals("combat", new Integer(17), event.explore);
    Assert.assertEquals("soldier", new Integer(7), event.soldier);
    Assert.assertEquals("exobiologist", new Integer(58), event.exobiologist);
    Assert.assertEquals("empire", new Integer(100), event.empire);
    Assert.assertEquals("federation", new Integer(100), event.federation);
    Assert.assertEquals("cqc", new Integer(0), event.cqc);
  }

  @Test
  public void testReputationEvent() {
    ReputationEvent event = getEvent(ReputationEvent.class, "{ \"timestamp\":\"2022-02-28T12:40:34Z\", \"event\":\"Reputation\", \"Empire\":75.000000, \"Federation\":73.781303, \"Alliance\":98.266197 }");

    Assert.assertNotNull(event);
    Assert.assertEquals("type", "Reputation", event.type);
    Assert.assertEquals("empire", new Double(75), event.empire);
    Assert.assertEquals("federation", new Double(73.781303), event.federation);
    Assert.assertEquals("alliance", new Double(98.266197), event.alliance);
    Assert.assertNull("independent", event.independent);
  }

  @Test
  public void testMusicEvent() {
    MusicEvent event = this.getEvent(MusicEvent.class, "{ \"timestamp\":\"2022-02-28T12:41:01Z\", \"event\":\"Music\", \"MusicTrack\":\"NoTrack\" }");

    Assert.assertNotNull(event);
    Assert.assertEquals("type", "Music", event.type);
    Assert.assertEquals("empire", "NoTrack", event.musicTrack);
  }

  @Test
  public void ShipTargetedStage3Event() {
    AtomicReference<ShipTargetedEvent> resultEvent = new AtomicReference<>(null);
    this.eliteDangerousAPIBuilder.addEventListener(ShipTargetedEvent.class,
            (ShipTargetedEvent.Listener) resultEvent::set);
    this.build();
    Event event = this.eliteDangerousAPI.parseEvent(JsonParser.parseString(
                    "{"
                            + "\"timestamp\":\"2022-10-06T14:23:01Z\","
                            + "\"event\":\"ShipTargeted\","
                            + "\"TargetLocked\":true,"
                            + "\"Ship\":\"viper\","
                            + "\"Ship_Localised\":\"Viper Mk III\","
                            + "\"ScanStage\":3,"
                            + "\"PilotName\":\"$ShipName_Police_Independent;\","
                            + "\"PilotName_Localised\":\"System Authority Vessel\","
                            + "\"PilotRank\":\"Master\","
                            + "\"ShieldHealth\":100.000000,"
                            + "\"HullHealth\":100.000000,"
                            + "\"Faction\":\"New HIP 35246 Liberals\","
                            + "\"LegalStatus\":\"Clean\","
                            + "\"Subsystem\":\"$int_powerplant_size3_class3_name;\","
                            + "\"Subsystem_Localised\":\"Power Plant\","
                            + "\"SubsystemHealth\":100.000000 }")
            .getAsJsonObject());
    this.eliteDangerousAPI.triggerEventIfNeededSafely(event);

    Assert.assertNotNull(resultEvent.get());
    Assert.assertEquals("type", "ShipTargeted", resultEvent.get().type);
    ShipTargetedStage3Event shipTargetedStage3Event = (ShipTargetedStage3Event) resultEvent.get();
    Assert.assertEquals("targetLocked", Boolean.TRUE, resultEvent.get().targetLocked);
    Assert.assertEquals("ship", "viper", shipTargetedStage3Event.ship);
    Assert.assertEquals("shipLocalised", "Viper Mk III", shipTargetedStage3Event.shipLocalised);
    Assert.assertEquals("scanStage", new Integer(3), shipTargetedStage3Event.scanStage);
    Assert.assertEquals("pilotName", "$ShipName_Police_Independent;", shipTargetedStage3Event.pilotName);
    Assert.assertEquals("pilotNameLocalised", "System Authority Vessel", shipTargetedStage3Event.pilotNameLocalised);
    Assert.assertEquals("pilotRank", "Master", shipTargetedStage3Event.pilotRank);
    Assert.assertEquals("shieldHealth", new Double(100), shipTargetedStage3Event.shieldHealth);
    Assert.assertEquals("hullHealth", new Double(100), shipTargetedStage3Event.hullHealth);
    Assert.assertEquals("faction", "New HIP 35246 Liberals", shipTargetedStage3Event.faction);
    Assert.assertEquals("legalStatus", "Clean", shipTargetedStage3Event.legalStatus);
    Assert.assertEquals("subsystem", "$int_powerplant_size3_class3_name;", shipTargetedStage3Event.subsystem);
    Assert.assertEquals("subsystemLocalised", "Power Plant", shipTargetedStage3Event.subsystemLocalised);
    Assert.assertEquals("subsystemHealth", new Double(100), shipTargetedStage3Event.subsystemHealth);
  }

  @Test
  public void testScanEvent() {
    ScanPlanetOrMoonEvent event = getEvent(ScanPlanetOrMoonEvent.class, "{ \"timestamp\":\"2022-02-06T19:02:57Z\", \"event\":\"Scan\", \"ScanType\":\"NavBeaconDetail\", \"BodyName\":\"Nemehi B 4 c\", \"BodyID\":60, \"Parents\":[ {\"Planet\":56}, {\"Star\":2}, {\"Null\":0} ], \"StarSystem\":\"Nemehi\", \"SystemAddress\":4511619877227, \"DistanceFromArrivalLS\":54173.102216, \"TidalLock\":true, \"TerraformState\":\"\", \"PlanetClass\":\"Icy body\", \"Atmosphere\":\"thin methane atmosphere\", \"AtmosphereType\":\"Methane\", \"AtmosphereComposition\":[ { \"Name\":\"Methane\", \"Percent\":100.000000 } ], \"Volcanism\":\"\", \"MassEM\":0.000147, \"Radius\":467427.750000, \"SurfaceGravity\":0.268696, \"SurfaceTemperature\":90.584389, \"SurfacePressure\":3631.814697, \"Landable\":false, \"Composition\":{ \"Ice\":0.824755, \"Rock\":0.159551, \"Metal\":0.015694 }, \"SemiMajorAxis\":1033000946.044922, \"Eccentricity\":0.000874, \"OrbitalInclination\":0.012871, \"Periapsis\":191.573354, \"OrbitalPeriod\":1686286.747456, \"RotationPeriod\":1657780.955823, \"AxialTilt\":0.252460, \"WasDiscovered\":false, \"WasMapped\":true }\n");
    Assert.assertNotNull(event);
    Assert.assertEquals("type", "Scan", event.type);
    Assert.assertEquals("systemAddress", 4511619877227L, event.systemAddress.longValue());
  }

  @Test
  public void testTouchDownEvent() {
    TouchdownEvent event = getEvent(TouchdownEvent.class, "{ \"timestamp\":\"2022-02-10T21:06:49Z\", \"event\":\"Touchdown\", \"PlayerControlled\":true, \"Taxi\":false, \"Multicrew\":false, \"StarSystem\":\"Bestii\", \"SystemAddress\":9467047323073, \"Body\":\"Bestii 8\", \"BodyID\":11, \"OnStation\":false, \"OnPlanet\":true, \"Latitude\":-48.613239, \"Longitude\":173.734497, \"NearestDestination\":\"$POIScenario_Watson_Wreckage_Buggy_01_Salvage_Easy; $USS_ThreatLevel:#threatLevel=1;\", \"NearestDestination_Localised\":\"Minor Wreckage [Threat&NBSP;1]\" }\n");

    Assert.assertNotNull(event);
    Assert.assertEquals("type", "Touchdown", event.type);
    Assert.assertEquals("systemAddress", 9467047323073L, event.systemAddress.longValue());
    Assert.assertEquals("bodyId", 11L, event.bodyID.longValue());
  }


  private <E extends Event> E getEvent(Class<E> clazz, String content) {
    AtomicReference<E> resultEvent = new AtomicReference<>(null);
    this.eliteDangerousAPIBuilder.addEventListener(clazz, new Event.Listener() {
        @Override
        public <T extends Event> void onTriggered(T event) {
            resultEvent.set((E)event);
        }
    });
    this.build();
    Event event = this.eliteDangerousAPI.parseEvent(JsonParser.parseString(content).getAsJsonObject());
    this.eliteDangerousAPI.triggerEventIfNeededSafely(event);
    return resultEvent.get();
  }
}
