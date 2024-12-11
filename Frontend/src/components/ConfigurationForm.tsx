import { useState } from "react";
import { SystemConfig } from "../App";

interface ConfigurationFormProps {
  onSubmit: (config: SystemConfig) => void;
}

function ConfigurationForm({ onSubmit }: ConfigurationFormProps) {
  const [config, setConfig] = useState<SystemConfig>({
    totalTickets: 50,
    ticketReleaseRate: 5,
    customerRetrievalRate: 2,
    maxTicketCapacity: 100,
  });

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;
    setConfig((prevConfig) => ({
      ...prevConfig,
      [name]: parseInt(value, 10),
    }));
  };

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    try {
      const response = await fetch("http://localhost:8080/ticketing/config", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(config),
      });
      const message = await response.text();
      console.log(message);
      onSubmit(config);
    } catch (error) {
      console.error("Error starting system:", error);
    }
  };

  return (
    <form onSubmit={handleSubmit} className="config-form">
      <h2>System Configuration</h2>
      <div>
        <label htmlFor="totalTickets">Total Tickets:</label>
        <input
          type="number"
          id="totalTickets"
          name="totalTickets"
          value={config.totalTickets}
          onChange={handleChange}
          required
        />
      </div>
      <div>
        <label htmlFor="ticketReleaseRate">Ticket Release Rate:</label>
        <input
          type="number"
          id="ticketReleaseRate"
          name="ticketReleaseRate"
          value={config.ticketReleaseRate}
          onChange={handleChange}
          required
        />
      </div>
      <div>
        <label htmlFor="customerRetrievalRate">Customer Retrieval Rate:</label>
        <input
          type="number"
          id="customerRetrievalRate"
          name="customerRetrievalRate"
          value={config.customerRetrievalRate}
          onChange={handleChange}
          required
        />
      </div>
      <div>
        <label htmlFor="maxTicketCapacity">Max Ticket Capacity:</label>
        <input
          type="number"
          id="maxTicketCapacity"
          name="maxTicketCapacity"
          value={config.maxTicketCapacity}
          onChange={handleChange}
          required
        />
      </div>
      <button type="submit">Start System</button>
    </form>
  );
}

export default ConfigurationForm;
