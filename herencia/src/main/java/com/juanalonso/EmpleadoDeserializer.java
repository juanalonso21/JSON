package com.juanalonso;
public class EmpleadoDeserializer implements JsonDeserializer<Empleado> {
    @Override
    public Empleado deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String tipo = jsonObject.get("tipo").getAsString();

        if ("Contable".equals(tipo)) {
            return context.deserialize(json, Contable.class);
        } else if ("Director".equals(tipo)) {
            return context.deserialize(json, Director.class);
        }
        return context.deserialize(json, Empleado.class);
    }
}