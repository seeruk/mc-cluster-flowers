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
    "type": "minecraft:crafting_shapeless",
    "ingredients": [
        {
            "item": "minecraft:$(echo $flower | sed 's/cluster_//g')"
        },
        {
            "item": "minecraft:$(echo $flower | sed 's/cluster_//g')"
        }
    ],
    "result": {
        "item": "clusterflowers:${flower}",
        "count": 2
    }
}
JSON

  cat << JSON > "$(echo $flower | sed 's/cluster_//g').json"
{
    "type": "minecraft:crafting_shapeless",
    "ingredients": [
        {
            "item": "clusterflowers:${flower}"
        }
    ],
    "result": {
        "item": "minecraft:$(echo $flower | sed 's/cluster_//g')",
        "count": 1
    }
}
JSON
done
