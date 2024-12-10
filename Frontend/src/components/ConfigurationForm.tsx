import { useState } from "react";
import { SystemConfig } from "../App";

interface ConfigurationFormProps {
  onSubmit: (config: SystemConfig) => void;
}

function ConfigurationForm({ onSubmit }: ConfigurationFormProps) {
  const [config, setConfig] = useState<SystemConfig>({
    totalTickets: 50,
    ticketReleaseRate: 1,
    customerRetrievalRate: 1,
    maxTicketCapacity: 100,
  });

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;
    setConfig((prevConfig) => ({
      ...prevConfig,
      [name]: parseInt(value, 10),
    }));
  };

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    onSubmit(config);
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
