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
    "variants": {
        "flowers=1": {
            "model": "clusterflowers:block/${flower}"
        },
        "flowers=2": {
            "model": "clusterflowers:block/two_${flower}"
        },
        "flowers=3": {
            "model": "clusterflowers:block/three_${flower}"
        },
        "flowers=4": {
            "model": "clusterflowers:block/four_${flower}"
        }
    }
}
JSON
done
