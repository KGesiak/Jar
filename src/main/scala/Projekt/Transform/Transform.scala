package Projekt.Transform

import Projekt.Case.Names
import Projekt.Case.Actors

object Transform {

  def isComposer(actors: Actors): Boolean = {
    if(actors.category==null) return false;
    return actors.category=="composer";
  }

  def isDivorced(names: Names): Boolean = {
    if(names.divorces==null) return false;
    return Integer.valueOf(names.divorces)>0;
  }

}