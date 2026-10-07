package jp.chatgpt.fantasyarmoriss;

import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

public final class ArmorTooltipHandler {
 @SubscribeEvent
 public static void tooltip(ItemTooltipEvent e){
  ItemStack stack=e.getItemStack();
  var key=BuiltInRegistries.ITEM.getKey(stack.getItem());
  if(key==null || !key.getNamespace().equals("fantasy_armor")) return;

  String id=key.getPath();
  ArmorSetRegistry.SetDef found=null;
  for(var s:ArmorSetRegistry.all()){
   if(("fantasy_armor:"+id).equals(s.helmet()) || ("fantasy_armor:"+id).equals(s.chestplate()) ||
      ("fantasy_armor:"+id).equals(s.leggings()) || ("fantasy_armor:"+id).equals(s.boots())){
    found=s; break;
   }
  }
  if(found==null)return;

  e.getToolTip().add(Component.empty());
  e.getToolTip().add(Component.literal("◆ Fantasy Armor Set").withStyle(ChatFormatting.GOLD));
  e.getToolTip().add(Component.literal("  分類: "+profileName(found.profile())).withStyle(ChatFormatting.GRAY));
  e.getToolTip().add(Component.literal("  2/4  "+tier2(found.profile())).withStyle(ChatFormatting.GREEN));
  e.getToolTip().add(Component.literal("  3/4  "+tier3(found.profile())).withStyle(ChatFormatting.AQUA));
  e.getToolTip().add(Component.literal("  4/4  "+tier4(found.profile())).withStyle(ChatFormatting.LIGHT_PURPLE));
  e.getToolTip().add(Component.literal("  ★ "+abilityName(found.key())).withStyle(ChatFormatting.GOLD));
  e.getToolTip().add(Component.literal("     "+abilityInfo(found.key())).withStyle(ChatFormatting.DARK_GRAY));
 }

 private static String profileName(ArmorSetRegistry.Profile p){return switch(p){
  case TACTIC_TANK->"戦術防御"; case BRUISER->"重戦士"; case SHADOW_BRUISER->"影の重戦士";
  case DARK_HYBRID->"闇の魔法戦士"; case BERSERKER->"狂戦士"; case HEAVY_SLAYER->"大型討伐";
  case SOLDIER->"万能兵士"; case ASSASSIN->"暗殺"; case VAMPIRIC_BRUISER->"吸血重戦士";
  case FORTRESS->"要塞"; case RELIC_HYBRID->"遺物魔法戦士"; case HUNTER->"狩人";
  case EXECUTIONER->"処刑人"; case CHARGER->"突撃"; case SENTINEL->"守護"; case HEROIC->"英雄";
  case BLOOD_HYBRID->"血の魔法戦士"; case DUELIST->"決闘"; case OLD_GUARD->"古参守護";
  case LANCER->"高速槍兵"; case PALADIN->"聖騎士"; case RONIN->"浪人"; case SILVER_GUARD->"銀騎士";
  case HOLY_HYBRID->"聖なる魔法戦士"; case AERIAL->"空戦機動"; case THIEF->"盗賊";
  case TWINNED->"万能双生"; case PURE_MAGE->"純魔法"; case WIND_MAGE->"風魔法";
 };}

 private static String tier2(ArmorSetRegistry.Profile p){return switch(p){
  case PURE_MAGE,WIND_MAGE->"魔力・最大マナを強化";
  case DARK_HYBRID,RELIC_HYBRID,BLOOD_HYBRID,PALADIN,HOLY_HYBRID,TWINNED->"物理攻撃と魔力を強化";
  case FORTRESS,SENTINEL,OLD_GUARD,TACTIC_TANK,SILVER_GUARD->"耐久力を強化";
  case ASSASSIN,HUNTER,DUELIST,LANCER,RONIN,AERIAL,THIEF->"攻撃・機動力を強化";
  default->"物理戦闘能力を強化";
 };}

 private static String tier3(ArmorSetRegistry.Profile p){return switch(p){
  case PURE_MAGE,WIND_MAGE->"魔力回復・魔法性能を追加強化";
  case DARK_HYBRID,RELIC_HYBRID,BLOOD_HYBRID,PALADIN,HOLY_HYBRID,TWINNED->"生命力・マナ・複合性能を追加強化";
  case FORTRESS,SENTINEL,OLD_GUARD,TACTIC_TANK,SILVER_GUARD->"防御・防具強度を追加強化";
  case ASSASSIN,HUNTER,DUELIST,LANCER,RONIN,AERIAL,THIEF->"攻撃速度・移動性能を追加強化";
  default->"攻撃・耐久性能を追加強化";
 };}

 private static String tier4(ArmorSetRegistry.Profile p){return switch(p){
  case PURE_MAGE,WIND_MAGE->"魔法性能が最大化 + 固有能力解禁";
  case DARK_HYBRID,RELIC_HYBRID,BLOOD_HYBRID,PALADIN,HOLY_HYBRID,TWINNED->"複合性能が最大化 + 固有能力解禁";
  case FORTRESS,SENTINEL,OLD_GUARD,TACTIC_TANK,SILVER_GUARD->"防御性能が最大化 + 固有能力解禁";
  case ASSASSIN,HUNTER,DUELIST,LANCER,RONIN,AERIAL,THIEF->"機動戦闘性能が最大化 + 固有能力解禁";
  default->"物理戦闘性能が最大化 + 固有能力解禁";
 };}

 private static String abilityName(String k){return switch(k){
  case "chess_board_knight"->"王手の構え"; case "crucible_knight"->"坩堝の猛進";
  case "dark_cover"->"深闇の追撃"; case "dark_lord"->"暗黒支配"; case "dead_gladiator"->"死闘の昂揚";
  case "dragonslayer"->"竜殺しの一撃"; case "eclipse_soldier"->"蝕の戦陣"; case "evening_ghost"->"黄昏の奇襲";
  case "flesh_of_the_feaster"->"飽食の血肉"; case "fog_guard"->"霧城の防壁"; case "forgotten_trace"->"忘却の残響";
  case "gilded_hunt"->"黄金狩猟"; case "golden_execution"->"黄金処刑"; case "golden_horns"->"黄金角の突撃";
  case "grave_sentinel"->"墓守の誓い"; case "hero"->"英雄の奮起"; case "lady_maria"->"血刃乱舞";
  case "malenia"->"不敗の剣舞"; case "old_knight"->"古騎士の不屈"; case "ornstein"->"雷槍疾駆";
  case "redeemer"->"贖罪の加護"; case "ronin"->"一閃"; case "silver_knight"->"銀壁反攻";
  case "spark_of_dawn"->"暁光共鳴"; case "sunset_wings"->"落日の翼"; case "thief"->"影盗み";
  case "twinned"->"双生共鳴"; case "wandering_wizard"->"魔力超過"; case "wind_worshipper"->"風神加速";
  default->"固有能力";
 };}

 private static String abilityInfo(String k){return switch(k){
  case "fog_guard","grave_sentinel","old_knight","redeemer","silver_knight","chess_board_knight","forgotten_trace"
    ->"被弾時に発動する防御能力（4/4限定）";
  case "dead_gladiator","flesh_of_the_feaster"->"敵撃破時に発動する強化・回復能力（4/4限定）";
  case "dark_lord","hero","spark_of_dawn","wandering_wizard"->"HP35%以下で発動する切り札（4/4限定）";
  default->"攻撃命中時に発動する戦闘能力（4/4限定）";
 };}
}
