package com.christophecvb.elitedangerous;

import com.christophecvb.elitedangerous.events.Event;
import com.christophecvb.elitedangerous.events.StatusEvent;
import com.christophecvb.elitedangerous.events.other.FriendsEvent;
import com.christophecvb.elitedangerous.events.other.MusicEvent;
import com.christophecvb.elitedangerous.events.startup.CommanderEvent;
import com.christophecvb.elitedangerous.events.startup.MaterialsEvent;
import com.christophecvb.elitedangerous.events.startup.ProgressEvent;
import com.christophecvb.elitedangerous.events.startup.RankEvent;
import com.christophecvb.elitedangerous.events.startup.ReputationEvent;
import com.christophecvb.elitedangerous.utils.GameFiles;
import com.google.gson.JsonParser;
import java.io.File;
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
    AtomicReference<FriendsEvent> resultEvent = new AtomicReference<>(null);
    this.eliteDangerousAPIBuilder.addEventListener(FriendsEvent.class,
        (FriendsEvent.Listener) resultEvent::set);
    this.build();
    Event event = this.eliteDangerousAPI.parseEvent(JsonParser.parseString(
            "{ \"timestamp\":\"2022-02-28T12:40:06Z\", \"event\":\"Friends\", \"Status\":\"Online\", \"Name\":\"Geraldine Shattner\" }")
        .getAsJsonObject());
    this.eliteDangerousAPI.triggerEventIfNeededSafely(event);

    Assert.assertNotNull(resultEvent.get());
    Assert.assertEquals("type", "Friends", resultEvent.get().type);
    Assert.assertEquals("status", "Online", resultEvent.get().status);
    Assert.assertEquals("name", "Geraldine Shattner", resultEvent.get().name);
  }

  @Test
  public void testCommanderEvent() {
    AtomicReference<CommanderEvent> resultEvent = new AtomicReference<>(null);
    this.eliteDangerousAPIBuilder.addEventListener(CommanderEvent.class,
        (CommanderEvent.Listener) resultEvent::set);
    this.build();
    Event event = this.eliteDangerousAPI.parseEvent(JsonParser.parseString(
            "{ \"timestamp\":\"2022-02-28T12:40:34Z\", \"event\":\"Commander\", \"FID\":\"F4032179\", \"Name\":\"Melbar Kaasom\" }")
        .getAsJsonObject());
    this.eliteDangerousAPI.triggerEventIfNeededSafely(event);

    Assert.assertNotNull(resultEvent.get());
    Assert.assertEquals("type", "Commander", resultEvent.get().type);
    Assert.assertEquals("fid", "F4032179", resultEvent.get().fid);
    Assert.assertEquals("name", "Melbar Kaasom", resultEvent.get().name);
  }

  @Test
  public void testMaterialsEvent() {
    AtomicReference<MaterialsEvent> resultEvent = new AtomicReference<>(null);
    this.eliteDangerousAPIBuilder.addEventListener(MaterialsEvent.class,
        (MaterialsEvent.Listener) resultEvent::set);
    this.build();
    Event event = this.eliteDangerousAPI.parseEvent(JsonParser.parseString(
            "{ \"timestamp\":\"2022-02-28T12:40:34Z\", \"event\":\"Materials\", \"Raw\":[ { \"Name\":\"arsenic\", \"Name_Localised\":\"Arsen\", \"Count\":57 }, { \"Name\":\"manganese\", \"Name_Localised\":\"Mangan\", \"Count\":250 }, { \"Name\":\"sulphur\", \"Name_Localised\":\"Schwefel\", \"Count\":295 }, { \"Name\":\"germanium\", \"Count\":228 }, { \"Name\":\"ruthenium\", \"Count\":150 }, { \"Name\":\"mercury\", \"Name_Localised\":\"Quecksilber\", \"Count\":124 }, { \"Name\":\"iron\", \"Name_Localised\":\"Eisen\", \"Count\":297 }, { \"Name\":\"cadmium\", \"Name_Localised\":\"Kadmium\", \"Count\":160 }, { \"Name\":\"nickel\", \"Count\":297 }, { \"Name\":\"carbon\", \"Name_Localised\":\"Kohlenstoff\", \"Count\":296 }, { \"Name\":\"antimony\", \"Name_Localised\":\"Antimon\", \"Count\":92 }, { \"Name\":\"molybdenum\", \"Name_Localised\":\"Molibdän\", \"Count\":200 }, { \"Name\":\"tin\", \"Name_Localised\":\"Zinn\", \"Count\":200 }, { \"Name\":\"zirconium\", \"Count\":84 }, { \"Name\":\"chromium\", \"Name_Localised\":\"Chrom\", \"Count\":250 }, { \"Name\":\"vanadium\", \"Count\":250 }, { \"Name\":\"phosphorus\", \"Name_Localised\":\"Phosphor\", \"Count\":296 }, { \"Name\":\"selenium\", \"Name_Localised\":\"Selen\", \"Count\":133 }, { \"Name\":\"tungsten\", \"Name_Localised\":\"Wolfram\", \"Count\":138 }, { \"Name\":\"polonium\", \"Count\":58 }, { \"Name\":\"niobium\", \"Name_Localised\":\"Niob\", \"Count\":171 }, { \"Name\":\"yttrium\", \"Count\":127 }, { \"Name\":\"zinc\", \"Name_Localised\":\"Zink\", \"Count\":250 }, { \"Name\":\"tellurium\", \"Name_Localised\":\"Tellur\", \"Count\":34 }, { \"Name\":\"technetium\", \"Count\":48 }, { \"Name\":\"lead\", \"Name_Localised\":\"Blei\", \"Count\":297 }, { \"Name\":\"rhenium\", \"Count\":123 }, { \"Name\":\"boron\", \"Name_Localised\":\"Bor\", \"Count\":117 } ], \"Manufactured\":[ { \"Name\":\"mechanicalequipment\", \"Name_Localised\":\"Mechanisches Equipment\", \"Count\":61 }, { \"Name\":\"conductivecomponents\", \"Name_Localised\":\"Leitfähige Komponenten\", \"Count\":12 }, { \"Name\":\"shieldemitters\", \"Name_Localised\":\"Schildemitter\", \"Count\":55 }, { \"Name\":\"salvagedalloys\", \"Name_Localised\":\"Geborgene Legierungen\", \"Count\":102 }, { \"Name\":\"crystalshards\", \"Name_Localised\":\"Kristallscherben\", \"Count\":180 }, { \"Name\":\"chemicalstorageunits\", \"Name_Localised\":\"Lagerungseinheiten für Chemiestoffe\", \"Count\":3 }, { \"Name\":\"gridresistors\", \"Name_Localised\":\"Gitterwiderstände\", \"Count\":221 }, { \"Name\":\"mechanicalscrap\", \"Name_Localised\":\"Mechanischer Schrott\", \"Count\":158 }, { \"Name\":\"heatconductionwiring\", \"Name_Localised\":\"Wärmeleitungsverdrahtung\", \"Count\":29 }, { \"Name\":\"wornshieldemitters\", \"Name_Localised\":\"Gebrauchte Schildemitter\", \"Count\":174 }, { \"Name\":\"chemicalprocessors\", \"Name_Localised\":\"Chemische Prozessoren\", \"Count\":58 }, { \"Name\":\"electrochemicalarrays\", \"Name_Localised\":\"Elektrochemische Detektoren\", \"Count\":3 }, { \"Name\":\"conductiveceramics\", \"Name_Localised\":\"Elektrokeramiken\", \"Count\":1 }, { \"Name\":\"conductivepolymers\", \"Name_Localised\":\"Leitfähige Polymere\", \"Count\":134 }, { \"Name\":\"compoundshielding\", \"Name_Localised\":\"Verbundschilde\", \"Count\":115 }, { \"Name\":\"mechanicalcomponents\", \"Name_Localised\":\"Mechanische Komponenten\", \"Count\":2 }, { \"Name\":\"shieldingsensors\", \"Name_Localised\":\"Schildsensoren\", \"Count\":56 }, { \"Name\":\"heatdispersionplate\", \"Name_Localised\":\"Wärmeverteilungsplatte\", \"Count\":80 }, { \"Name\":\"phasealloys\", \"Name_Localised\":\"Phasenlegierungen\", \"Count\":92 }, { \"Name\":\"chemicaldistillery\", \"Name_Localised\":\"Chemiedestillerie\", \"Count\":20 }, { \"Name\":\"highdensitycomposites\", \"Name_Localised\":\"Komposite hoher Dichte\", \"Count\":100 }, { \"Name\":\"heatvanes\", \"Name_Localised\":\"Wärmeleitbleche\", \"Count\":33 }, { \"Name\":\"uncutfocuscrystals\", \"Name_Localised\":\"Fehlerhafte Fokuskristalle\", \"Count\":54 }, { \"Name\":\"chemicalmanipulators\", \"Name_Localised\":\"Chemische Manipulatoren\", \"Count\":9 }, { \"Name\":\"refinedfocuscrystals\", \"Name_Localised\":\"Raffinierte Laserkristalle\", \"Count\":150 }, { \"Name\":\"galvanisingalloys\", \"Name_Localised\":\"Galvanisierende Legierungen\", \"Count\":28 }, { \"Name\":\"heatexchangers\", \"Name_Localised\":\"Wärmeaustauscher\", \"Count\":11 }, { \"Name\":\"hybridcapacitors\", \"Name_Localised\":\"Hybridkondensatoren\", \"Count\":2 }, { \"Name\":\"focuscrystals\", \"Name_Localised\":\"Laserkristalle\", \"Count\":200 }, { \"Name\":\"basicconductors\", \"Name_Localised\":\"Einfache Leiter\", \"Count\":89 }, { \"Name\":\"exquisitefocuscrystals\", \"Name_Localised\":\"Erlesene Laserkristalle\", \"Count\":100 }, { \"Name\":\"biotechconductors\", \"Name_Localised\":\"Biotech-Leiter\", \"Count\":90 }, { \"Name\":\"thermicalloys\", \"Name_Localised\":\"Thermische Legierungen\", \"Count\":27 }, { \"Name\":\"filamentcomposites\", \"Name_Localised\":\"Filament-Komposite\", \"Count\":62 }, { \"Name\":\"guardian_powercell\", \"Name_Localised\":\"Guardian-Energiezelle\", \"Count\":66 }, { \"Name\":\"guardian_powerconduit\", \"Name_Localised\":\"Guardian-Energieleiter\", \"Count\":87 }, { \"Name\":\"heatresistantceramics\", \"Name_Localised\":\"Hitzefeste Keramik\", \"Count\":34 }, { \"Name\":\"temperedalloys\", \"Name_Localised\":\"Vergütete Legierungen\", \"Count\":3 }, { \"Name\":\"protoheatradiators\", \"Name_Localised\":\"Proto-Wärmestrahler\", \"Count\":46 }, { \"Name\":\"protolightalloys\", \"Name_Localised\":\"Leichte Legierungen (Proto)\", \"Count\":60 }, { \"Name\":\"protoradiolicalloys\", \"Name_Localised\":\"Radiologische Legierungen (Proto)\", \"Count\":41 }, { \"Name\":\"fedproprietarycomposites\", \"Name_Localised\":\"Kompositwerkstoffe\", \"Count\":106 }, { \"Name\":\"militarysupercapacitors\", \"Name_Localised\":\"Militärische Superkondensatoren\", \"Count\":2 }, { \"Name\":\"fedcorecomposites\", \"Name_Localised\":\"Core Dynamics Kompositwerkstoffe\", \"Count\":37 }, { \"Name\":\"militarygradealloys\", \"Name_Localised\":\"Militärqualitätslegierungen\", \"Count\":26 }, { \"Name\":\"precipitatedalloys\", \"Name_Localised\":\"Gehärtete Legierungen\", \"Count\":119 }, { \"Name\":\"compactcomposites\", \"Name_Localised\":\"Kompaktkomposite\", \"Count\":49 }, { \"Name\":\"guardian_sentinel_weaponparts\", \"Name_Localised\":\"Guardian-Wache-Waffenteile\", \"Count\":18 }, { \"Name\":\"guardian_sentinel_wreckagecomponents\", \"Name_Localised\":\"Guardian-Wrackteilkomponenten\", \"Count\":33 }, { \"Name\":\"unknownenergysource\", \"Name_Localised\":\"Sensorenfragment\", \"Count\":16 }, { \"Name\":\"improvisedcomponents\", \"Name_Localised\":\"Behelfskomponenten\", \"Count\":3 }, { \"Name\":\"imperialshielding\", \"Name_Localised\":\"Imperiale Schilde\", \"Count\":8 } ], \"Encoded\":[ { \"Name\":\"legacyfirmware\", \"Name_Localised\":\"Spezial-Legacy-Firmware\", \"Count\":124 }, { \"Name\":\"shieldpatternanalysis\", \"Name_Localised\":\"Abweichende Schildeinsatz-Analysen\", \"Count\":95 }, { \"Name\":\"emissiondata\", \"Name_Localised\":\"Unerwartete Emissionsdaten\", \"Count\":56 }, { \"Name\":\"disruptedwakeechoes\", \"Name_Localised\":\"Atypische FSA-Stör-Aufzeichnungen\", \"Count\":105 }, { \"Name\":\"fsdtelemetry\", \"Name_Localised\":\"Anormale FSA-Telemetrie\", \"Count\":119 }, { \"Name\":\"consumerfirmware\", \"Name_Localised\":\"Modifizierte Consumer-Firmware\", \"Count\":25 }, { \"Name\":\"decodedemissiondata\", \"Name_Localised\":\"Entschlüsselte Emissionsdaten\", \"Count\":95 }, { \"Name\":\"compactemissionsdata\", \"Name_Localised\":\"Anormale kompakte Emissionsdaten\", \"Count\":11 }, { \"Name\":\"shieldcyclerecordings\", \"Name_Localised\":\"Gestörte Schildzyklus-Aufzeichnungen\", \"Count\":58 }, { \"Name\":\"shielddensityreports\", \"Name_Localised\":\"Untypische Schildscans\", \"Count\":98 }, { \"Name\":\"scandatabanks\", \"Name_Localised\":\"Scan-Datenbanken unter Verschluss\", \"Count\":89 }, { \"Name\":\"scanarchives\", \"Name_Localised\":\"Unidentifizierte Scan-Archive\", \"Count\":91 }, { \"Name\":\"encryptedfiles\", \"Name_Localised\":\"Ungewöhnliche verschlüsselte Files\", \"Count\":15 }, { \"Name\":\"hyperspacetrajectories\", \"Name_Localised\":\"Exzentrische Hyperraum-Routen\", \"Count\":21 }, { \"Name\":\"wakesolutions\", \"Name_Localised\":\"Seltsame FSA-Zielorte\", \"Count\":37 }, { \"Name\":\"dataminedwake\", \"Name_Localised\":\"FSA-Daten-Cache-Ausnahmen\", \"Count\":18 }, { \"Name\":\"encryptioncodes\", \"Name_Localised\":\"Getaggte Verschlüsselungscodes\", \"Count\":78 }, { \"Name\":\"industrialfirmware\", \"Name_Localised\":\"Gecrackte Industrie-Firmware\", \"Count\":11 }, { \"Name\":\"bulkscandata\", \"Name_Localised\":\"Anormale Massen-Scan-Daten\", \"Count\":174 }, { \"Name\":\"archivedemissiondata\", \"Name_Localised\":\"Irreguläre Emissionsdaten\", \"Count\":41 }, { \"Name\":\"shieldsoakanalysis\", \"Name_Localised\":\"Inkonsistente Schildleistungsanalysen\", \"Count\":83 }, { \"Name\":\"unknownshipsignature\", \"Name_Localised\":\"Thargoiden-Schiffssignatur\", \"Count\":3 }, { \"Name\":\"encryptionarchives\", \"Name_Localised\":\"Atypische Verschlüsselungsarchive\", \"Count\":138 }, { \"Name\":\"adaptiveencryptors\", \"Name_Localised\":\"Adaptive Verschlüsselungserfassung\", \"Count\":84 }, { \"Name\":\"embeddedfirmware\", \"Name_Localised\":\"Modifizierte integrierte Firmware\", \"Count\":72 }, { \"Name\":\"securityfirmware\", \"Name_Localised\":\"Sicherheits-Firmware-Patch\", \"Count\":139 }, { \"Name\":\"scrambledemissiondata\", \"Name_Localised\":\"Außergewöhnliche verschlüsselte Emissionsdaten\", \"Count\":187 }, { \"Name\":\"encodedscandata\", \"Name_Localised\":\"Divergente Scandaten\", \"Count\":123 }, { \"Name\":\"shieldfrequencydata\", \"Name_Localised\":\"Verdächtige Schildfrequenz-Daten\", \"Count\":6 }, { \"Name\":\"ancientculturaldata\", \"Name_Localised\":\"Beta-Muster-Obeliskendaten\", \"Count\":6 }, { \"Name\":\"classifiedscandata\", \"Name_Localised\":\"Geheimes Scan-Fragment\", \"Count\":13 }, { \"Name\":\"symmetrickeys\", \"Name_Localised\":\"Offene symmetrische Schlüssel\", \"Count\":5 } ] }")
        .getAsJsonObject());
    this.eliteDangerousAPI.triggerEventIfNeededSafely(event);

    Assert.assertNotNull(resultEvent.get());
    Assert.assertEquals("type", "Materials", resultEvent.get().type);
    Assert.assertEquals("raw.size", 28, resultEvent.get().raw.size());
    Assert.assertEquals("raw[0].name", "arsenic", resultEvent.get().raw.get(0).name);
    Assert.assertEquals("raw[0].count", new Integer(57), resultEvent.get().raw.get(0).count);
    Assert.assertEquals("encoded.size", 32, resultEvent.get().encoded.size());
    Assert.assertEquals("encoded[0].name", "legacyfirmware", resultEvent.get().encoded.get(0).name);
    Assert.assertEquals("encoded[0].count", new Integer(124),
        resultEvent.get().encoded.get(0).count);
    Assert.assertEquals("manufactured.size", 52, resultEvent.get().manufactured.size());
    Assert.assertEquals("manufactured[0].name", "mechanicalequipment",
        resultEvent.get().manufactured.get(0).name);
    Assert.assertEquals("manufactured[0].count", new Integer(61),
        resultEvent.get().manufactured.get(0).count);
  }

  @Test
  public void testRankEvent() {
    AtomicReference<RankEvent> resultEvent = new AtomicReference<>(null);
    this.eliteDangerousAPIBuilder.addEventListener(RankEvent.class,
        (RankEvent.Listener) resultEvent::set);
    this.build();
    Event event = this.eliteDangerousAPI.parseEvent(JsonParser.parseString(
            "{ \"timestamp\":\"2022-02-28T12:40:34Z\", \"event\":\"Rank\", \"Combat\":5, \"Trade\":9, \"Explore\":8, \"Soldier\":2, \"Exobiologist\":4, \"Empire\":14, \"Federation\":14, \"CQC\":0 }")
        .getAsJsonObject());
    this.eliteDangerousAPI.triggerEventIfNeededSafely(event);

    Assert.assertNotNull(resultEvent.get());
    Assert.assertEquals("type", "Rank", resultEvent.get().type);
    Assert.assertEquals("combat", new Integer(5), resultEvent.get().combat);
    Assert.assertEquals("trade", new Integer(9), resultEvent.get().trade);
    Assert.assertEquals("combat", new Integer(8), resultEvent.get().explore);
    Assert.assertEquals("soldier", new Integer(2), resultEvent.get().soldier);
    Assert.assertEquals("exobiologist", new Integer(4), resultEvent.get().exobiologist);
    Assert.assertEquals("empire", new Integer(14), resultEvent.get().empire);
    Assert.assertEquals("federation", new Integer(14), resultEvent.get().federation);
    Assert.assertEquals("cqc", new Integer(0), resultEvent.get().cqc);
  }

  @Test
  public void testProgressEvent() {
    AtomicReference<ProgressEvent> resultEvent = new AtomicReference<>(null);
    this.eliteDangerousAPIBuilder.addEventListener(ProgressEvent.class,
        (ProgressEvent.Listener) resultEvent::set);
    this.build();
    Event event = this.eliteDangerousAPI.parseEvent(JsonParser.parseString(
            "{ \"timestamp\":\"2022-02-28T12:40:34Z\", \"event\":\"Progress\", \"Combat\":11, \"Trade\":76, \"Explore\":17, \"Soldier\":7, \"Exobiologist\":58, \"Empire\":100, \"Federation\":100, \"CQC\":0 }")
        .getAsJsonObject());
    this.eliteDangerousAPI.triggerEventIfNeededSafely(event);

    Assert.assertNotNull(resultEvent.get());
    Assert.assertEquals("type", "Progress", resultEvent.get().type);
    Assert.assertEquals("combat", new Integer(11), resultEvent.get().combat);
    Assert.assertEquals("trade", new Integer(76), resultEvent.get().trade);
    Assert.assertEquals("combat", new Integer(17), resultEvent.get().explore);
    Assert.assertEquals("soldier", new Integer(7), resultEvent.get().soldier);
    Assert.assertEquals("exobiologist", new Integer(58), resultEvent.get().exobiologist);
    Assert.assertEquals("empire", new Integer(100), resultEvent.get().empire);
    Assert.assertEquals("federation", new Integer(100), resultEvent.get().federation);
    Assert.assertEquals("cqc", new Integer(0), resultEvent.get().cqc);
  }

  @Test
  public void testReputationEvent() {
    AtomicReference<ReputationEvent> resultEvent = new AtomicReference<>(null);
    this.eliteDangerousAPIBuilder.addEventListener(ReputationEvent.class,
        (ReputationEvent.Listener) resultEvent::set);
    this.build();
    Event event = this.eliteDangerousAPI.parseEvent(JsonParser.parseString(
            "{ \"timestamp\":\"2022-02-28T12:40:34Z\", \"event\":\"Reputation\", \"Empire\":75.000000, \"Federation\":73.781303, \"Alliance\":98.266197 }")
        .getAsJsonObject());
    this.eliteDangerousAPI.triggerEventIfNeededSafely(event);

    Assert.assertNotNull(resultEvent.get());
    Assert.assertEquals("type", "Reputation", resultEvent.get().type);
    Assert.assertEquals("empire", new Double(75), resultEvent.get().empire);
    Assert.assertEquals("federation", new Double(73.781303), resultEvent.get().federation);
    Assert.assertEquals("alliance", new Double(98.266197), resultEvent.get().alliance);
    Assert.assertNull("independent", resultEvent.get().independent);
  }

  @Test
  public void testMusicEvent() {
    AtomicReference<MusicEvent> resultEvent = new AtomicReference<>(null);
    this.eliteDangerousAPIBuilder.addEventListener(MusicEvent.class,
        (MusicEvent.Listener) resultEvent::set);
    this.build();
    Event event = this.eliteDangerousAPI.parseEvent(JsonParser.parseString(
            "{ \"timestamp\":\"2022-02-28T12:41:01Z\", \"event\":\"Music\", \"MusicTrack\":\"NoTrack\" }")
        .getAsJsonObject());
    this.eliteDangerousAPI.triggerEventIfNeededSafely(event);

    Assert.assertNotNull(resultEvent.get());
    Assert.assertEquals("type", "Music", resultEvent.get().type);
    Assert.assertEquals("empire", "NoTrack", resultEvent.get().musicTrack);
  }
}
