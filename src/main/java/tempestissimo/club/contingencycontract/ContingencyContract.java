package tempestissimo.club.contingencycontract;

import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.java.JavaPlugin;
import tempestissimo.club.contingencycontract.contract.*;
import tempestissimo.club.contingencycontract.utils.*;

import java.util.ArrayList;

public final class ContingencyContract extends JavaPlugin {
    public Configuration config;
    public ContingencyContract plugin;
    public ArrayList<Contract> contracts = new ArrayList<>();
    public Commands command;
    public Services service;
    public GameCtrl ctrl;
    public Stats stats;
    public Voter vote;

    public WorldManage worldManage;

    public WorldLocation location;
//    public WorldCreate world;

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.plugin = this;
        this.saveDefaultConfig();
        this.config = this.getConfig();
        this.worldManage = new WorldManage(plugin, config);
        this.ctrl = new GameCtrl(plugin,config);
        this.stats = new Stats(plugin, config);
        this.vote = new Voter(plugin,config);
        this.location = new WorldLocation(plugin,config);
        getServer().getPluginManager().registerEvents(new CommonFix(plugin,config),this);
        getServer().getPluginManager().registerEvents(this.ctrl,this);
        //
        this.loadContracts();
        this.command = new Commands(this.plugin,this.config);
        getServer().getPluginCommand("cc").setExecutor(command);
        getServer().getPluginCommand("cc").setTabCompleter(command);
        this.service = new Services(plugin,config);


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    /**
     * Load contracts from config.
     */
    public void loadContracts(){
        contracts.add(new DeathLimit(config,plugin));
        contracts.add(new Erode(config,plugin));
        contracts.add(new HighValueTarget(config,plugin));
        contracts.add(new Octane(config,plugin));
        contracts.add(new Stimulation(config,plugin));
        contracts.add(new CreeperFusion(config,plugin));
        contracts.add(new SharpArrow(config,plugin));
        contracts.add(new MechanicalDisaster(config,plugin));
        contracts.add(new Silence(config,plugin));
        contracts.add(new ShareDamage(config,plugin));
        contracts.add(new FireObsessed(config,plugin));
        contracts.add(new CovertOperation(config,plugin));
        contracts.add(new ThickMob(config,plugin));
        contracts.add(new Burden(config,plugin));
        contracts.add(new FromEnd(config,plugin));
        contracts.add(new LongLifeArmy(config,plugin));
        contracts.add(new BurnOut(config,plugin));
        contracts.add(new PoorTools(config,plugin));
        contracts.add(new HeavyShield(config,plugin));
        contracts.add(new Eutrophic(config,plugin));
        contracts.add(new Bubble(config,plugin));
        contracts.add(new MineralPaucity(config,plugin));
        contracts.add(new HematopoieticDisorders(config,plugin));
        contracts.add(new Tasteless(config,plugin));
        contracts.add(new EnderLord(config,plugin));
        contracts.add(new Insomnia(config,plugin));
        contracts.add(new Pneumonia(config,plugin));
        contracts.add(new ForeverNight(config,plugin));
        contracts.add(new OnFire(config,plugin));
        contracts.add(new WhiteTerror(config,plugin));
        contracts.add(new NoFish(config,plugin));
//        contracts.add(new ZombiePiglinAnger(config,plugin));
        getServer().getPluginManager().registerEvents(contracts.get(0),this);
        getServer().getPluginManager().registerEvents(contracts.get(1),this);
        getServer().getPluginManager().registerEvents(contracts.get(2),this);
        getServer().getPluginManager().registerEvents(contracts.get(3),this);
        getServer().getPluginManager().registerEvents(contracts.get(4),this);
        getServer().getPluginManager().registerEvents(contracts.get(5),this);
        getServer().getPluginManager().registerEvents(contracts.get(6),this);
        getServer().getPluginManager().registerEvents(contracts.get(7),this);
        getServer().getPluginManager().registerEvents(contracts.get(8),this);
        getServer().getPluginManager().registerEvents(contracts.get(9),this);
        getServer().getPluginManager().registerEvents(contracts.get(10),this);
        getServer().getPluginManager().registerEvents(contracts.get(11),this);
        getServer().getPluginManager().registerEvents(contracts.get(12),this);
        getServer().getPluginManager().registerEvents(contracts.get(13),this);
        getServer().getPluginManager().registerEvents(contracts.get(14),this);
        getServer().getPluginManager().registerEvents(contracts.get(15),this);
        getServer().getPluginManager().registerEvents(contracts.get(16),this);
        getServer().getPluginManager().registerEvents(contracts.get(17),this);
        getServer().getPluginManager().registerEvents(contracts.get(18),this);
        getServer().getPluginManager().registerEvents(contracts.get(19),this);
        getServer().getPluginManager().registerEvents(contracts.get(20),this);
        getServer().getPluginManager().registerEvents(contracts.get(21),this);
        getServer().getPluginManager().registerEvents(contracts.get(22),this);
        getServer().getPluginManager().registerEvents(contracts.get(23),this);
        getServer().getPluginManager().registerEvents(contracts.get(24),this);
        getServer().getPluginManager().registerEvents(contracts.get(25),this);
        getServer().getPluginManager().registerEvents(contracts.get(26),this);
        getServer().getPluginManager().registerEvents(contracts.get(27),this);
        getServer().getPluginManager().registerEvents(contracts.get(28),this);
        getServer().getPluginManager().registerEvents(contracts.get(29),this);
        getServer().getPluginManager().registerEvents(contracts.get(30),this);
//        getServer().getPluginManager().registerEvents(contracts.get(31),this);
    }

}
