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
    "type": "minecraft:block",
    "pools": [
        {
            "rolls": 1.0,
            "bonus_rolls": 0.0,
            "entries": [
                {
                    "type": "minecraft:item",
                    "functions": [
                        {
                            "function": "minecraft:set_count",
                            "conditions": [
                                {
                                    "condition": "minecraft:block_state_property",
                                    "block": "clusterflowers:${flower}",
                                    "properties": {
                                        "flowers": "2"
                                    }
                                }
                            ],
                            "count": 2.0,
                            "add": false
                        },
                        {
                            "function": "minecraft:set_count",
                            "conditions": [
                                {
                                    "condition": "minecraft:block_state_property",
                                    "block": "clusterflowers:${flower}",
                                    "properties": {
                                        "flowers": "3"
                                    }
                                }
                            ],
                            "count": 3.0,
                            "add": false
                        },
                        {
                            "function": "minecraft:set_count",
                            "conditions": [
                                {
                                    "condition": "minecraft:block_state_property",
                                    "block": "clusterflowers:${flower}",
                                    "properties": {
                                        "flowers": "4"
                                    }
                                }
                            ],
                            "count": 4.0,
                            "add": false
                        },
                        {
                            "function": "minecraft:explosion_decay"
                        }
                    ],
                    "name": "clusterflowers:${flower}"
                }
            ]
        }
    ]
}
JSON
done
