#!/usr/bin/env bash

flowers=(
  "cluster_dandelion"
  "cluster_poppy"
  "cluster_blue_orchid"
  "cluster_allium"
  "cluster_azure_bluet"
  "cluster_red_tulip"
  "cluster_orange_tulip"
  "cluster_white_tulip"
  "cluster_pink_tulip"
  "cluster_oxeye_daisy"
  "cluster_cornflower"
  "cluster_lily_of_the_valley"
  "cluster_wither_rose"
)

for flower in ${flowers[@]}; do
  cat << JSON > "${flower}.json"
{
    "parent": "clusterflowers:block/cross",
    "textures": {
        "cross": "minecraft:block/$(echo $flower | sed 's/cluster_//g')"
    }
}
JSON

  cat << JSON > "two_${flower}.json"
{
    "parent": "clusterflowers:block/two_cross",
    "textures": {
        "cross": "minecraft:block/$(echo $flower | sed 's/cluster_//g')"
    }
}
JSON

  cat << JSON > "three_${flower}.json"
{
    "parent": "clusterflowers:block/three_cross",
    "textures": {
        "cross": "minecraft:block/$(echo $flower | sed 's/cluster_//g')"
    }
}
JSON

  cat << JSON > "four_${flower}.json"
{
    "parent": "clusterflowers:block/four_cross",
    "textures": {
        "cross": "minecraft:block/$(echo $flower | sed 's/cluster_//g')"
    }
}
JSON
done
