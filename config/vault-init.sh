#!/bin/sh

VAULT_DEV_TOKEN=0fbcac20-cc0a-4230-a0a2-7a3ac201a29b

vault auth ${VAULT_DEV_TOKEN}

vault write secret/catalog-service @${CONFIG_DIR}/catalog-service.json