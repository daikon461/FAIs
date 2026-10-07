package jp.chatgpt.fantasyarmoriss;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.*;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import java.util.*;

public final class ArmorSetHandler {
 private static final String NS="fantasy_armor_iss";
 @SubscribeEvent public static void tick(PlayerTickEvent.Post e){
  Player p=e.getEntity(); if(p.level().isClientSide())return;
  clear(p);
  for(var s:ArmorSetRegistry.all()){int n=count(p,s); if(n>=2)apply(p,s,n);}
 }
 private static int count(Player p,ArmorSetRegistry.SetDef s){
  int n=0;
  if(id(p.getItemBySlot(EquipmentSlot.HEAD)).equals(s.helmet()))n++;
  if(id(p.getItemBySlot(EquipmentSlot.CHEST)).equals(s.chestplate()))n++;
  if(id(p.getItemBySlot(EquipmentSlot.LEGS)).equals(s.leggings()))n++;
  if(id(p.getItemBySlot(EquipmentSlot.FEET)).equals(s.boots()))n++;
  return n;
 }
 private static String id(net.minecraft.world.item.ItemStack st){var k=BuiltInRegistries.ITEM.getKey(st.getItem());return k==null?"":k.toString();}
 private static void apply(Player p,ArmorSetRegistry.SetDef s,int n){
  switch(s.profile()){
case TACTIC_TANK -> {
 tier(p,s,n, 0.04000, 0.03000, 0.10000, 2.00000, 2.00000, 0.02000, 0.15000, 0.00000, 0.00000, 0.00000, 0.00000);
}
case BRUISER -> {
 tier(p,s,n, 0.16000, 0.03000, 0.08000, 1.00000, 2.00000, 0.00000, 0.10000, 0.00000, 0.00000, 0.00000, 0.00000);
}
case SHADOW_BRUISER -> {
 tier(p,s,n, 0.14000, 0.08000, 0.05000, 0.00000, 1.00000, 0.07000, 0.00000, 0.04000, 0.00000, 0.00000, 0.00000);
}
case DARK_HYBRID -> {
 tier(p,s,n, 0.11000, 0.05000, 0.07000, 0.00000, 1.00000, 0.03000, 0.00000, 0.14000, 0.12000, 0.08000, 0.05000);
}
case BERSERKER -> {
 tier(p,s,n, 0.22000, 0.10000, 0.04000, 0.00000, 0.00000, 0.03000, 0.00000, 0.00000, 0.00000, 0.00000, 0.00000);
}
case HEAVY_SLAYER -> {
 tier(p,s,n, 0.25000, -0.04000, 0.08000, 1.00000, 3.00000, -0.02000, 0.20000, 0.00000, 0.00000, 0.00000, 0.00000);
}
case SOLDIER -> {
 tier(p,s,n, 0.12000, 0.06000, 0.08000, 1.00000, 1.00000, 0.03000, 0.08000, 0.00000, 0.00000, 0.00000, 0.00000);
}
case ASSASSIN -> {
 tier(p,s,n, 0.14000, 0.16000, 0.00000, 0.00000, 0.00000, 0.13000, 0.00000, 0.00000, 0.00000, 0.00000, 0.00000);
}
case VAMPIRIC_BRUISER -> {
 tier(p,s,n, 0.15000, 0.05000, 0.14000, 0.00000, 1.00000, 0.02000, 0.00000, 0.04000, 0.00000, 0.00000, 0.00000);
}
case FORTRESS -> {
 tier(p,s,n, 0.03000, 0.00000, 0.22000, 4.00000, 4.00000, -0.03000, 0.30000, 0.00000, 0.00000, 0.00000, 0.00000);
}
case RELIC_HYBRID -> {
 tier(p,s,n, 0.08000, 0.04000, 0.08000, 1.00000, 1.00000, 0.03000, 0.00000, 0.11000, 0.10000, 0.08000, 0.04000);
}
case HUNTER -> {
 tier(p,s,n, 0.12000, 0.12000, 0.03000, 0.00000, 0.00000, 0.10000, 0.00000, 0.00000, 0.00000, 0.00000, 0.00000);
}
case EXECUTIONER -> {
 tier(p,s,n, 0.24000, -0.02000, 0.06000, 0.00000, 2.00000, 0.00000, 0.12000, 0.00000, 0.00000, 0.00000, 0.00000);
}
case CHARGER -> {
 tier(p,s,n, 0.15000, 0.04000, 0.08000, 1.00000, 1.00000, 0.10000, 0.15000, 0.00000, 0.00000, 0.00000, 0.00000);
}
case SENTINEL -> {
 tier(p,s,n, 0.06000, 0.02000, 0.18000, 3.00000, 3.00000, 0.00000, 0.25000, 0.00000, 0.00000, 0.00000, 0.00000);
}
case HEROIC -> {
 tier(p,s,n, 0.15000, 0.08000, 0.12000, 1.00000, 2.00000, 0.05000, 0.10000, 0.00000, 0.00000, 0.00000, 0.00000);
}
case BLOOD_HYBRID -> {
 tier(p,s,n, 0.10000, 0.12000, 0.06000, 0.00000, 1.00000, 0.08000, 0.00000, 0.13000, 0.08000, 0.10000, 0.04000);
}
case DUELIST -> {
 tier(p,s,n, 0.17000, 0.18000, 0.03000, 0.00000, 0.00000, 0.10000, 0.00000, 0.00000, 0.00000, 0.00000, 0.00000);
}
case OLD_GUARD -> {
 tier(p,s,n, 0.09000, 0.02000, 0.16000, 2.00000, 3.00000, -0.01000, 0.20000, 0.00000, 0.00000, 0.00000, 0.00000);
}
case LANCER -> {
 tier(p,s,n, 0.16000, 0.20000, 0.04000, 0.00000, 1.00000, 0.09000, 0.05000, 0.00000, 0.00000, 0.00000, 0.00000);
}
case PALADIN -> {
 tier(p,s,n, 0.09000, 0.03000, 0.15000, 2.00000, 2.00000, 0.00000, 0.18000, 0.08000, 0.10000, 0.08000, 0.03000);
}
case RONIN -> {
 tier(p,s,n, 0.18000, 0.14000, 0.03000, 0.00000, 0.00000, 0.11000, 0.00000, 0.00000, 0.00000, 0.00000, 0.00000);
}
case SILVER_GUARD -> {
 tier(p,s,n, 0.11000, 0.05000, 0.12000, 2.00000, 2.00000, 0.02000, 0.15000, 0.00000, 0.00000, 0.00000, 0.00000);
}
case HOLY_HYBRID -> {
 tier(p,s,n, 0.08000, 0.05000, 0.10000, 1.00000, 1.00000, 0.04000, 0.08000, 0.15000, 0.14000, 0.12000, 0.06000);
}
case AERIAL -> {
 tier(p,s,n, 0.10000, 0.12000, 0.04000, 0.00000, 0.00000, 0.16000, 0.00000, 0.06000, 0.05000, 0.00000, 0.00000);
}
case THIEF -> {
 tier(p,s,n, 0.10000, 0.20000, 0.00000, 0.00000, 0.00000, 0.18000, 0.00000, 0.00000, 0.00000, 0.00000, 0.00000);
}
case TWINNED -> {
 tier(p,s,n, 0.13000, 0.10000, 0.09000, 1.00000, 1.00000, 0.05000, 0.08000, 0.07000, 0.06000, 0.04000, 0.02000);
}
case PURE_MAGE -> {
 tier(p,s,n, 0.00000, 0.00000, 0.04000, 0.00000, 0.00000, 0.03000, 0.00000, 0.28000, 0.30000, 0.22000, 0.12000);
}
case WIND_MAGE -> {
 tier(p,s,n, 0.03000, 0.06000, 0.03000, 0.00000, 0.00000, 0.18000, 0.00000, 0.22000, 0.20000, 0.18000, 0.10000);
}
  }
 }
 // Totals are intentionally distributed 35% / 30% / 35% across 2p,3p,4p.
 private static void tier(Player p,ArmorSetRegistry.SetDef s,int n,double atk,double asp,double hp,double armor,double tough,double move,double kb,double spell,double mana,double regen,double cd){
  if(n>=2) stats(p,s.key()+"_2",.35,atk,asp,hp,armor,tough,move,kb,spell,mana,regen,cd);
  if(n>=3) stats(p,s.key()+"_3",.30,atk,asp,hp,armor,tough,move,kb,spell,mana,regen,cd);
  if(n>=4) stats(p,s.key()+"_4",.35,atk,asp,hp,armor,tough,move,kb,spell,mana,regen,cd);
 }
 private static void stats(Player p,String k,double q,double atk,double asp,double hp,double armor,double tough,double move,double kb,double spell,double mana,double regen,double cd){
  mult(p,Attributes.ATTACK_DAMAGE,k+"_atk",atk*q); mult(p,Attributes.ATTACK_SPEED,k+"_asp",asp*q);
  mult(p,Attributes.MAX_HEALTH,k+"_hp",hp*q); value(p,Attributes.ARMOR,k+"_armor",armor*q);
  value(p,Attributes.ARMOR_TOUGHNESS,k+"_tough",tough*q); mult(p,Attributes.MOVEMENT_SPEED,k+"_move",move*q);
  mult(p,Attributes.KNOCKBACK_RESISTANCE,k+"_kb",kb*q);
  magic(p,"spell_power",k+"_spell",spell*q); magic(p,"max_mana",k+"_mana",mana*q);
  magic(p,"mana_regen",k+"_regen",regen*q); magic(p,"cooldown_reduction",k+"_cd",cd*q);
 }
 private static void clear(Player p){
  for(var h:p.getAttributes().getSyncableAttributes()){
   var i=p.getAttribute(h.getAttribute()); if(i==null)continue;
   var ids=new ArrayList<ResourceLocation>();
   for(var m:i.getModifiers())if(m.id().getNamespace().equals(NS))ids.add(m.id());
   for(var id:ids)i.removeModifier(id);
  }
 }
 private static void mult(Player p,Holder<Attribute>a,String id,double x){if(x!=0)add(p,a,id,x,AttributeModifier.Operation.ADD_MULTIPLIED_BASE);}
 private static void value(Player p,Holder<Attribute>a,String id,double x){if(x!=0)add(p,a,id,x,AttributeModifier.Operation.ADD_VALUE);}
 private static void add(Player p,Holder<Attribute>a,String id,double x,AttributeModifier.Operation op){
  var i=p.getAttribute(a);if(i==null)return;var rl=ResourceLocation.fromNamespaceAndPath(NS,id);
  if(i.getModifier(rl)==null)i.addTransientModifier(new AttributeModifier(rl,x,op));
 }
 private static void magic(Player p,String path,String id,double x){
  if(x==0)return; var key=ResourceLocation.fromNamespaceAndPath("irons_spellbooks",path);
  var h=BuiltInRegistries.ATTRIBUTE.getHolder(key);if(h.isPresent())add(p,h.get(),id,x,AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
 }
}
