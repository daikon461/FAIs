package jp.chatgpt.fantasyarmoriss;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
@Mod(FantasyArmorISS.MODID)
public final class FantasyArmorISS {
 public static final String MODID="fantasy_armor_iss";
 public FantasyArmorISS(){
  NeoForge.EVENT_BUS.register(ArmorSetHandler.class);
  NeoForge.EVENT_BUS.register(CombatAbilities.class);
 }
}
